package com.example.version2.dto;

import com.example.version2.entities.Jeu;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreatePayment {

     private String customerId;
     private Jeu[] jeux;

     public int getPrix(){
          int prix = 0;
          for (Jeu jeu : jeux) {
               prix+=jeu.getPrix();
          }
          return prix;
     }
}
