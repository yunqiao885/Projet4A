package com.example.version2.controller.web;

import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.entities.Jeu;
import com.example.version2.entities.Panier;
import com.example.version2.entities.Utilisateur;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.*;
import com.stripe.net.Webhook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WebhookController {

    private Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @Value("${stripe.webhook.secret}")
    private String endpointSecret;

    @PostMapping("/webhook")  // stripe listen --forward-to localhost:8080/webhook
    public String handleStripeEvent(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader){

        if (sigHeader == null){
            return "";
        }

        Event event;
                // Only verify the event if you have an endpoint secret defined.
                // Otherwise use the basic event deserialized with GSON.
                try {
                    event = Webhook.constructEvent(
                            payload, sigHeader, endpointSecret
                    );
                } catch (SignatureVerificationException e) {
                    // Invalid signature
                    logger.info("⚠️  Webhook error while validating signature.");
                    return "";
                }

            // Deserialize the nested object inside the event
            EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
            StripeObject stripeObject = null;
            if (dataObjectDeserializer.getObject().isPresent()) {
                stripeObject = dataObjectDeserializer.getObject().get();
            } else {
                // Deserialization failed, probably due to an API version mismatch.
                // Refer to the Javadoc documentation on `EventDataObjectDeserializer` for
                // instructions on how to handle this case, or return an error here.
            }
            // Handle the event
            switch (event.getType()) {
                case "payment_intent.succeeded":
                    PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
                    logger.info("Payment for id : "+ paymentIntent.getId() +" Amount : "+" " + paymentIntent.getAmount() + " succeeded.");
                    // Then define and call a method to handle the successful payment intent.
                    System.out.println("Payment for id : "+ paymentIntent.getId() +" Amount : "+" " + paymentIntent.getAmount() + " succeeded." + paymentIntent.getCustomer());
                    System.out.println("Customer: "+paymentIntent.getCustomer()+ " Mode de paiement: "+paymentIntent.getPaymentMethod());
                     handlePaymentIntentSucceeded(paymentIntent);
                    break;
                default:
                    logger.warn("Unhandled event type: " + event.getType());
                    break;
            }
            return "";
    }

    private void handlePaymentIntentSucceeded(PaymentIntent paymentIntent) {
        Utilisateur user = utilisateurInterface.findByCustomerId(paymentIntent.getCustomer());
        for (Jeu jeu: user.getPanier().getJeux()) {
            user.getBibliotheque().getJeux().add(jeu);
        }
        Panier panier = user.getPanier();
        panier.setJeux(new ArrayList<Jeu>());
        user.setPanier(panier);
        utilisateurInterface.save(user);
    }
}
