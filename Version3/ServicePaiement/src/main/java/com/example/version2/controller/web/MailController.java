package com.example.version2.controller.web;

import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.dto.CreatePayment;
import com.example.version2.entities.Jeu;
import com.example.version2.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MailController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping("/send-mail")
    public void sendMail(@RequestBody CreatePayment createPayment) {
        Utilisateur utilisateur = utilisateurInterface.findByCustomerId(createPayment.getCustomerId());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(utilisateur.getEmail());

        //obtenir le temps
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();

        message.setSubject("Votre code d'activation");

        String text = "Bonjour "+utilisateur.getUsername()+"\n"
                + "\nMerci pour cette recente transaction sur MDJ.\n" +
                "\nLes articles suivants ont été achetés sur MDJ a la date du "+sdf.format(date)+" :\n";
        for (Jeu jeu: createPayment.getJeux()) {
            text+=jeu.getNom()+" : "+ jeu.getPrix()+"€ . \tCode d'activation : "+jeu.getActiveCode()+"\n";
        }
        text+="\nNous vous souhaitons d'agreables heures de jeu\n" +
                "\nL'équipe MDJ";

        message.setText(text);
        try {
            mailSender.send(message);
            System.out.println("Envoyer réussir!");
        } catch (Exception e) {
            System.out.println("Il y a un problème quand envoyer.");
        }
    }
}
