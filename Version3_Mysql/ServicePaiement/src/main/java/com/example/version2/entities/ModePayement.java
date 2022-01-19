package com.example.version2.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class ModePayement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String no_carte;
    private Date date_exp;

    @OneToOne(mappedBy = "modePayement")
    private Utilisateur user;

    public ModePayement(String no_carte, Date date_exp) {
        this.no_carte = no_carte;
        this.date_exp = date_exp;
    }
}
