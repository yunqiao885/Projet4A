package com.example.version2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
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
    private Date date_publication;

    @OneToMany(mappedBy = "jeu")
    public List<Avis> avis;        // Liste des avis avec ce jeu

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "jeux")
    private List<Panier> paniers;                              // Liste des paniers avec ces jeux

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},  mappedBy = "jeux")
    private List<Bibliotheque> bibliotheques;                  // Liste des bibliotheques avec ces jeux

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "id"),       // jeu_id
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")  // categorie_id
    )
    private List<Categorie> categories;

    public Jeu(int id, String nom, String description, int prix, String nom_fabricant, Date date_publication) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.nom_fabricant = nom_fabricant;
        this.date_publication = date_publication;
    }


}
