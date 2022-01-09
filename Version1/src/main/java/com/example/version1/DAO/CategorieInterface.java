package com.example.version1.DAO;

import com.example.version1.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieInterface extends JpaRepository<Categorie,Integer> {
}
