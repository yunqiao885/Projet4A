package com.example.version1.DAO;

import com.example.version1.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementInterface extends JpaRepository<Payement, Integer> {
}
