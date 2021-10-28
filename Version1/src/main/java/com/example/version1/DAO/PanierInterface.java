package com.example.version1.DAO;

import com.example.version1.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierInterface extends JpaRepository<Panier, Integer> {
}
