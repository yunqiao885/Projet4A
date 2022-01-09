package com.example.version1.controlleurs;

import com.example.version1.DAO.UtilisateurInterface;
import com.example.version1.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UtilisateurController {
    @Autowired
    private UtilisateurInterface utilisateurInterface;

    @GetMapping(value = "users")
    public List<Utilisateur> users(){
        return utilisateurInterface.findAll();
    }

    @GetMapping(value = "users/{id}")
    public Utilisateur getUtilisateur(@PathVariable int id){
        return utilisateurInterface.findById(id).get();
    }

    @PostMapping(path = "/users")
    public Utilisateur save(@RequestBody Utilisateur utilisateur){
        return utilisateurInterface.save(utilisateur);
    }

    @PutMapping("/users")
    public Utilisateur update(@RequestBody Utilisateur utilisateur,int id){
        utilisateur.setId(id);
        return utilisateurInterface.save(utilisateur);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id){
        utilisateurInterface.deleteById(id);
    }
}
