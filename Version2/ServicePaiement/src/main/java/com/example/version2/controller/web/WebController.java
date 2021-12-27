package com.example.version2.controller.web;

import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.entities.Utilisateur;
import com.example.version2.controller.form.CheckoutForm;
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



}
