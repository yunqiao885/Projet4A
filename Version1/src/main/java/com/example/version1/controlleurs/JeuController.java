package com.example.version1.controlleurs;

import com.example.version1.DAO.JeuInterface;
import com.example.version1.DAO.UtilisateurInterface;
import com.example.version1.entities.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class JeuController {
    @Autowired
    private JeuInterface jeuInterface;

    @GetMapping(value = "/bonjour")
    public String affichier(){
        return "Bonjour!";
    }

    @GetMapping(value = "jeux")
    public List<Jeu> jeux(){
        return jeuInterface.findAll();
    }

    @GetMapping(value = "jeux/{id}")
    public Jeu getJeu(@PathVariable int id){
        return jeuInterface.findById(id).get();
    }

    @PostMapping(path = "/jeux")
    public Jeu save(@RequestBody Jeu jeu){
        return jeuInterface.save(jeu);
    }

    @PutMapping("/jeux")
    public Jeu update(@RequestBody Jeu jeu,@PathVariable int id){
        jeu.setId(id);
        return jeuInterface.save(jeu);
    }

    @DeleteMapping("/jeux/{id}")
    public void delete(@PathVariable int id){
        jeuInterface.deleteById(id);
    }


}
