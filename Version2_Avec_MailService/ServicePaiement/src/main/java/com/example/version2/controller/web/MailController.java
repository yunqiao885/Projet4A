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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MailController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping("/SendMail")
    public void sendMail(@RequestBody CreatePayment createPayment) {
        Utilisateur utilisateur = utilisateurInterface.findByCustomerId(createPayment.getCustomerId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(utilisateur.getEmail());

        message.setSubject("Votre code d'activation");

        message.setText("Bonjour cher client:\n");

        //Affichier les informations d'achat
        Jeu[] jeux = createPayment.getJeux();

        //obtenir le temps
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();

        for (int i = 0; i < jeux.length; i++) {
            String name = jeux[i].getNom();
            String code = jeux[i].getActiveCode();

            message.setText("\n Merci pour acheter le jeu: " + name + ". Votre code d'activation est " + code + ". Ce mail est envoyé automatiquement. Ne pas divulguer ce code.\n");
        }

        message.setText("Cette commande est créé le "+ sdf.format(date));


        try {
            mailSender.send(message);
            System.out.println("Envoyer réussir!");
        } catch (Exception e) {
            System.out.println("Il y a un problème quand envoyer.");
        }
    }
}
