package com.example.version2.controller.data;

import com.example.version2.dao.JeuInterface;
import com.example.version2.entities.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JeuController {

    @Autowired
    private JeuInterface jeuInterface;

    @GetMapping(value = "jeux")
    public List<Jeu> jeux(){ return jeuInterface.findAll(); }
}
