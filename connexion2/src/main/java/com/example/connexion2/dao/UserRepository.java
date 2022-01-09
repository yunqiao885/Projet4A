package com.example.connexion2.dao;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);


}
