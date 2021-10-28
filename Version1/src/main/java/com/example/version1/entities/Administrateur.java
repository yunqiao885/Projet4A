package com.example.version1.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Administrateur extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Administrateur(String username, String email, String password) {
        super(username, email, password);
    }
}
