package com.example.version2.dao;

import com.example.version2.entities.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliothequeInterface extends JpaRepository<Bibliotheque, Integer> {
}
