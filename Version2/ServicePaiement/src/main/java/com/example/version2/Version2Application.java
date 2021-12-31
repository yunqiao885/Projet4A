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
            jeuInterface.save(new Jeu("Clash Of Clan","Jeu de strategie",200,"Alfred","10/03/2020", null));
            jeuInterface.save(new Jeu("Monster Hunter","Jeu de chasse",800,"Capcom","10/03/2020", null));
            jeuInterface.save(new Jeu("Call Of Duty","Jeu de tir",1000,"ActiVision","10/03/2020", null));
            jeuInterface.save(new Jeu("Need for Speed","Jeu de course",400,"Forza","10/03/2020", null));
            jeuInterface.save(new Jeu("Sims 4","Jeu de simulation",500,"Electronic Arts","10/03/2020", null));
            jeuInterface.save(new Jeu("Streef Fighter","Jeu de combat",700,"Capcom","10/03/2020", null));


            utilisateurInterface.save(new Utilisateur("tenede","tenede@tene.com", "123", new Panier(10), new Bibliotheque(), null));
            utilisateurInterface.save(new Utilisateur("yunqiao","yunqiao@zhang.com", "456", new Panier(200), new Bibliotheque(), null));
            utilisateurInterface.save(new Utilisateur("tankeu","tankeu@ivan.com", "789", new Panier(44), new Bibliotheque(), null));

        };
    }

}
