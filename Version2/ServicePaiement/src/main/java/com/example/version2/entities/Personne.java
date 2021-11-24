package com.example.version2.entities;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personne {

    private String username;
    private String email;
    private String password;


}
