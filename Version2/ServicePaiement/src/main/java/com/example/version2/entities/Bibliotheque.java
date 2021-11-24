package com.example.version2.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Bibliotheque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "bibliotheque")
    private Utilisateur user;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "id"),       // bibliotheque_id
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")  // jeu_id
    )
    private List<Jeu> jeux;


    public Bibliotheque() {
        this.jeux = new ArrayList<Jeu>();
    }
}
