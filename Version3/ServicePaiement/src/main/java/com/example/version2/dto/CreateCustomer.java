package com.example.version2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateCustomer {
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numero;
    private String codePostal;
    private String ville;

}
