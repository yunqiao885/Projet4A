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
public class CustomerController {

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @PostMapping("/create-customer-id")
    public int createCustomerId(@RequestBody CreateCustomer createCustomer) throws StripeException {

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
        Utilisateur user = new Utilisateur(createCustomer.getUsername(),createCustomer.getEmail(),createCustomer.getPassword(),new Panier(), new Bibliotheque(), customer.getId());
        utilisateurInterface.save(user);
        return user.getId();
    }

    @PostMapping("/get-customer-id")
    public int getCustomerId(@RequestBody CreateCustomer createCustomer) throws StripeException {
        Utilisateur user = utilisateurInterface.findByUsernameAndPassword(createCustomer.getUsername(), createCustomer.getPassword());
        if (user == null) return 0;
        else return user.getId();
    }


}
