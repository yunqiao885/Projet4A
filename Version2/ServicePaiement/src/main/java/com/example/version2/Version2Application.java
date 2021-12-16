package com.example.version2;

import com.example.version2.dao.AvisInterface;
import com.example.version2.dao.JeuInterface;
import com.example.version2.dao.UtilisateurInterface;
import com.example.version2.entities.Bibliotheque;
import com.example.version2.entities.Jeu;
import com.example.version2.entities.Panier;
import com.example.version2.entities.Utilisateur;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class Version2Application {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public void setup() {
        Stripe.apiKey = stripeApiKey;
    }

    public static void main(String[] args) {
        SpringApplication.run(Version2Application.class, args);
    }

    @Bean
    CommandLineRunner runner   (UtilisateurInterface utilisateurInterface, AvisInterface avisInterface, JeuInterface jeuInterface){
        return args -> {
            jeuInterface.save(new Jeu(1,"Clash Of Clan","Jeu de strategie",200,"Alfred",new Date(2021,2,3)));
            jeuInterface.save(new Jeu(2,"Monster Hunter","Jeu de chasse",800,"Capcom",new Date(2022,2,3)));
            jeuInterface.save(new Jeu(3,"Call Of Duty","Jeu de tir",1000,"ActiVision",new Date(2022,2,3)));
            jeuInterface.save(new Jeu(4,"Need for Speed","Jeu de course",400,"Forza",new Date(2022,2,3)));
            jeuInterface.save(new Jeu(5,"Sims 4","Jeu de simulation",500,"Electronic Arts",new Date(2022,2,3)));
            jeuInterface.save(new Jeu(6,"Streef Fighter","Jeu de combat",700,"Capcom",new Date(2022,2,3)));


            utilisateurInterface.save(new Utilisateur("tenede","tenede@tene.com", "123", new Panier(10), new Bibliotheque()));
            utilisateurInterface.save(new Utilisateur("yunqiao","yunqiao@zhang.com", "456", new Panier(200), new Bibliotheque()));
            utilisateurInterface.save(new Utilisateur("tankeu","tankeu@ivan.com", "789", new Panier(44), new Bibliotheque()));

        };
    }

}
