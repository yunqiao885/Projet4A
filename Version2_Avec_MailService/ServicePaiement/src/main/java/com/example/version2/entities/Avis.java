package com.example.version2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Avis {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date last_modif;
    private String text;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")   // Jeu_id fk
    private Jeu jeu;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")  // user_id fk
    private Utilisateur user;
}
