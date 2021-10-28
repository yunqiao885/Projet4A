package com.example.version1.DAO;

import com.example.version1.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurInterface extends JpaRepository<Administrateur, Integer> {
}
