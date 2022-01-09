package com.example.connexion2.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private  String role;

    protected User() {

    }

    public User(Long id,String username,String password,String telephone,String role) {
        this.id=id;
        this.password=password;
        this.username=username;
        this.telephone=telephone;
        this.role=role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}
}
