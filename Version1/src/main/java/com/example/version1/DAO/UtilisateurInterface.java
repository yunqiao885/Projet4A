package com.example.version1.DAO;

import com.example.version1.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurInterface extends JpaRepository<Utilisateur, Integer> {
}
