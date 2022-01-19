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
import java.io.IOException;

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
    CommandLineRunner runner   (UtilisateurInterface utilisateurInterface, JeuInterface jeuInterface){
        return args -> {
            jeuInterface.save(new Jeu("Clash Of Clan","Jeu de strategie",20,"Alfred","10/03/2020", null));
            jeuInterface.save(new Jeu("Monster Hunter","Jeu de chasse",80,"Capcom","10/03/2020", null));
            jeuInterface.save(new Jeu("Call Of Duty","Jeu de tir",100,"ActiVision","10/03/2020", null));
            jeuInterface.save(new Jeu("Need for Speed","Jeu de course",40,"Forza","10/03/2020", null));
            jeuInterface.save(new Jeu("Sims 4","Jeu de simulation",50,"Electronic Arts","10/03/2020", null));
            jeuInterface.save(new Jeu("Streef Fighter","Jeu de combat",70,"Capcom","10/03/2020", null));

        };
    }

}
