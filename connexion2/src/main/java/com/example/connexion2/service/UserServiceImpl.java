package com.example.connexion2.service;

import com.example.connexion2.dao.User;
import com.example.connexion2.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean login(User user) {
        User loginUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());

        return loginUser==null?false:true;
    }

    @Override
    public List<User> findAll() {
        Iterable<User> list = userRepository.findAll();
        return (List<User>)list;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

}
