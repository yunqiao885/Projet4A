package com.example.version1.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Data @Getter @Setter @NoArgsConstructor
public class Categorie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "categories")
    private List<Jeu> jeux;

    public Categorie(String name) {
        this.name = name;
    }
}
