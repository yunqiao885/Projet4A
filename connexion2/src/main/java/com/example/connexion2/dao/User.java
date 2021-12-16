package com.example.connexion2.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int identifiant;
    private String username;
    private String password;
    private String telephone;

    protected User() {

    }

    public User(int identifiant,String username,String password,String telephone) {
        this.identifiant=identifiant;
        this.password=password;
        this.username=username;
        this.telephone=telephone;
    }

    public int getId() {
        return identifiant;
    }
    public void setId(Long id) {
        this.identifiant = identifiant;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
