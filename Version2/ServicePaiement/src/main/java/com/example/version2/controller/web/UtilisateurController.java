package com.example.version2.controller.web;

import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.dto.CreateCustomer;
import com.example.version2.entities.Bibliotheque;
import com.example.version2.entities.Panier;
import com.example.version2.entities.Utilisateur;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurController {

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @PostMapping("/create-customer-id")
    public String createCustomerId(@RequestBody CreateCustomer createCustomer) throws StripeException {

        // model.addAttribute("stripePublicKey", stripePublicKey);  Supprimer Model en faisant des appels d'api
        CustomerCreateParams params = CustomerCreateParams.builder()
                .setEmail(createCustomer.getEmail())
                .setName(createCustomer.getNom())
                .setPhone(createCustomer.getNumero())
                .setAddress(CustomerCreateParams.Address.builder()
                        .setCity(createCustomer.getVille())
                        .setPostalCode(createCustomer.getCodePostal())
                        .build()
                )
                .build();
        Customer customer = Customer.create(params);
        utilisateurInterface.save(new Utilisateur(createCustomer.getUsername(),createCustomer.getEmail(),createCustomer.getPassword(),new Panier(), new Bibliotheque(), customer.getId()));
        return customer.getId();
    }


}
