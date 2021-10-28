package com.example.version1.DAO;

import com.example.version1.entities.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliothequeInterface extends JpaRepository<Bibliotheque, Integer> {
}
