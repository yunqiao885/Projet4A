package com.example.version2.dao;

import com.example.version2.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurInterface extends JpaRepository<Administrateur, Integer> {
}
