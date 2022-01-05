package com.example.version1.controlleurs;

import com.example.version1.DAO.AvisInterface;
import com.example.version1.DAO.UtilisateurInterface;
import com.example.version1.entities.Avis;
import com.example.version1.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AvisController {
    @Autowired
    private AvisInterface avisInterface;

    @GetMapping(value = "comments")
    public List<Avis> comments(){
        return avisInterface.findAll();
    }

    @GetMapping(value = "comments/{id}")
    public Avis getAvis(@PathVariable int id){
        return avisInterface.findById(id).get();
    }

    @PostMapping(path = "/comments")
    public Avis save(@RequestBody Avis avis){
        return avisInterface.save(avis);
    }

    @PutMapping("/comments")
    public Avis update(@RequestBody Avis avis,int id){
        avis.setId(id);
        return avisInterface.save(avis);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable int id){
        avisInterface.deleteById(id);
    }
}
