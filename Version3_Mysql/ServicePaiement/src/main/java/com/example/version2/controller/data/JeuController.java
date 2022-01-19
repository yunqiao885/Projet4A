package com.example.version2.controller.data;

import com.example.version2.dao.JeuInterface;
import com.example.version2.entities.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JeuController {

    @Autowired
    private JeuInterface jeuInterface;

    @GetMapping(value = "jeux")
    public List<Jeu> jeux(){ return jeuInterface.findAll(); }

    @GetMapping(value = "jeux/{id}")
    public Jeu getJeu(@PathVariable int id){
        return jeuInterface.findById(id).get();
    }

    @PostMapping(path = "/jeux")
    public Jeu save(@RequestBody Jeu jeu){
        return jeuInterface.save(jeu);
    }

    @PutMapping("/jeux/{id}")
    public Jeu update(@RequestBody Jeu jeu, @PathVariable int id){
        jeu.setId(id);
        return jeuInterface.save(jeu);
    }

    @DeleteMapping("/jeux/{id}")
    public void delete(@PathVariable int id){
        jeuInterface.deleteById(id);
    }
}

