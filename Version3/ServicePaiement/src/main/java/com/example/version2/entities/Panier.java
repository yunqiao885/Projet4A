package com.example.version2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Panier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int prix_total;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "id"),       // panier_id
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")  // jeu_id
    )
    private List<Jeu> jeux;

    @OneToMany(mappedBy = "panier")
    private List<Payement> payements;    // Liste des payements

    public Panier(int prix_total) {
        this.prix_total = prix_total;
        this.jeux = new ArrayList<Jeu>();
        this.payements = new ArrayList<Payement>();
    }
}
