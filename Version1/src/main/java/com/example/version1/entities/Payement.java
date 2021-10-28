package com.example.version1.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payement {
    @Id
    private int no_payement;
    private Date date_payement;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")   // panier_id
    private Panier panier;
}
