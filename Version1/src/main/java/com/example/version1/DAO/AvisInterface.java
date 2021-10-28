package com.example.version1.DAO;

import com.example.version1.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisInterface extends JpaRepository<Avis, Integer> {
}
