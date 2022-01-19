package com.example.version2.dao;

import com.example.version2.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisInterface extends JpaRepository<Avis, Integer> {
}
