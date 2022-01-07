package com.example.version2.controller.web;

import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.dto.CreatePayment;
import com.example.version2.entities.ActiveCode;
import com.example.version2.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MailController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping("/GetUserMail")
    public String getUserMail(@RequestBody CreatePayment createPayment) throws Exception{
        Utilisateur utilisateur = utilisateurInterface.findByCustomerId(createPayment.getCustomerId());
        return utilisateur.getEmail();
    }

    @PostMapping("/GetUserMail/SendMail")
    public void sendMail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);

        message.setSubject("Votre code d'activation");

        String code = ActiveCode.generateCode();
        message.setText("Bonjour cher client:\n"
                + "\n Votre code d'activation est " + code + ". Ce mail est envoyé automatiquement. Ne pas divulguer ce code.");

        try {
            mailSender.send(message);
            System.out.println("Envoyer réussir!");
        } catch (Exception e) {
            System.out.println("Il y a un problème quand envoyer.");
        }
    }
}
