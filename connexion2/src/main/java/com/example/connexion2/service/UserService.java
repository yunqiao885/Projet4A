package com.example.connexion2.service;

import com.example.connexion2.dao.User;

import java.util.List;

public interface UserService {
    void save(User user);
    boolean login(User user);
    List<User> findAll();
    User findById(Long id);
}
