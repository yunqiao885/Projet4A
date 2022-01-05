package com.example.version2.dao;

import com.example.version2.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface UtilisateurInterface extends JpaRepository<Utilisateur, Integer> {
    public Utilisateur findByUsername(String username);   // http://localhost:8080/utilisateurs/search/findByUsername?username="username"
    public Utilisateur findByCustomerId(String customerId);
}
