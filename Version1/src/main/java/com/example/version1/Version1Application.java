package com.example.version1;

import com.example.version1.DAO.AvisInterface;
import com.example.version1.DAO.JeuInterface;
import com.example.version1.DAO.PanierInterface;
import com.example.version1.DAO.UtilisateurInterface;
import com.example.version1.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class Version1Application {

    public static void main(String[] args) {

        SpringApplication.run(Version1Application.class, args);
    }

    @Bean
    CommandLineRunner runner   (UtilisateurInterface utilisateurInterface, AvisInterface avisInterface, JeuInterface jeuInterface){
        return args -> {
            jeuInterface.save(new Jeu(1,"ClashOfClan","Jeu de strategie",200,"Alfred",new Date(2021,2,3)));
            jeuInterface.save(new Jeu(2,"ClashOfClan2","Jeu de strategie",300,"Alfred",new Date(2022,2,3)));

            utilisateurInterface.save(new Utilisateur("tenede","tenede@tene.com", "123", new Panier(10), new Bibliotheque()));
            utilisateurInterface.save(new Utilisateur("yunqiao","yunqiao@zhang.com", "456", new Panier(200), new Bibliotheque()));
            utilisateurInterface.save(new Utilisateur("tankeu","tankeu@ivan.com", "789", new Panier(44), new Bibliotheque()));

        };
    }
}
