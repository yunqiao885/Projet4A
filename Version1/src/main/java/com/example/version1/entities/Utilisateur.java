package com.example.version1.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @Getter @Setter
public class Utilisateur extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")   // modePayement_id
    private ModePayement modePayement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")   // panier_id
    private Panier panier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")   // bibliotheque_id
    private Bibliotheque bibliotheque;

    @OneToMany(mappedBy = "user")
    public List<Avis> avis;

    public Utilisateur(String username, String email, String password, Panier panier, Bibliotheque bibliotheque) {
        super(username, email, password);
        this.panier = panier;
        this.bibliotheque = bibliotheque;
    }


}
