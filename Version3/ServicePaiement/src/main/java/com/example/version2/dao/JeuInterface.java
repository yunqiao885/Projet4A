package com.example.version2.dao;

import com.example.version2.entities.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuInterface extends JpaRepository<Jeu, Integer> {
}
