package com.example.version2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private int prix;
    private String nom_fabricant;
    private String date_publication;
    private String priceId;

    //Code d'activation
    private String activeCode;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "id"),       // jeu_id
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")  // categorie_id
    )
    private List<Categorie> categories;

    public Jeu(String nom, String description, int prix, String nom_fabricant, String date_publication, String priceId) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.nom_fabricant = nom_fabricant;
        this.date_publication = date_publication;
        this.priceId = priceId;

        //chaque jeu a un code
        this.activeCode=ActiveCode.generateCode();
    }


}
