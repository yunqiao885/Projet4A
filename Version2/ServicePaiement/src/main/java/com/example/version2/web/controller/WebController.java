package com.example.version2.web.controller;

import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.entities.Utilisateur;
import com.example.version2.web.form.CheckoutForm;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class WebController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @GetMapping("/checkout")
    public String home(Model model){
        model.addAttribute("checkoutForm", new CheckoutForm());
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "checkoutForm";
    }

    @PostMapping("/checkout")
    public String validate(@ModelAttribute @Valid CheckoutForm checkoutForm, BindingResult bindingResult, Model model) throws StripeException {
        if (bindingResult.hasErrors()){
            return "checkoutForm";
        }
        model.addAttribute("stripePublicKey", stripePublicKey);

        Utilisateur user = utilisateurInterface.findByEmail(checkoutForm.getEmail()); // Chercher un moyen plus pratique de recuperer l'user (Session)
        if (user.getCustomerId()==null){
            CustomerCreateParams params = CustomerCreateParams.builder()
                    .setEmail(checkoutForm.getEmail())
                    .setName(checkoutForm.getNom())
                    .setPhone(checkoutForm.getNumero())
                    .setAddress(CustomerCreateParams.Address.builder()
                            .setCity(checkoutForm.getCity())
                            .setPostalCode(checkoutForm.getCodePostal())
                            .build()
                    )
                    .build();
            Customer customer = Customer.create(params);
            model.addAttribute("customerId", customer.getId());
        }else{
            model.addAttribute("customerId", user.getCustomerId());
        }

        return "checkout";
    }



}
