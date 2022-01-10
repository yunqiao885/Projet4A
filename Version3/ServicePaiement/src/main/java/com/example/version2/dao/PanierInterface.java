package com.example.version2.dao;

import com.example.version2.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierInterface extends JpaRepository<Panier, Integer> {
}
