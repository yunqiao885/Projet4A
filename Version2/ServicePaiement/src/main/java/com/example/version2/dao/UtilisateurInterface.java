package com.example.version2.dao;

import com.example.version2.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurInterface extends JpaRepository<Utilisateur, Integer> {
    public Utilisateur findByEmail(String email);
}
