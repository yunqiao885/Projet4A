package com.example.version2.dao;

import com.example.version2.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementInterface extends JpaRepository<Payement, Integer> {
}
