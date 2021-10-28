package com.example.version1.DAO;

import com.example.version1.entities.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JeuInterface extends JpaRepository<Jeu, Integer> {
}
