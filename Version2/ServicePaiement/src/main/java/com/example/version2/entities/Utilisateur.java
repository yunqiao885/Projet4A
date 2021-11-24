package com.example.version2.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<Avis> avis;

    public String customerId;

    public Utilisateur(String username, String email, String password, Panier panier, Bibliotheque bibliotheque) {
        super(username, email, password);
        this.panier = panier;
        this.bibliotheque = bibliotheque;
    }

    // Id bibliotheque a referencer
    // id mode de payement

}
