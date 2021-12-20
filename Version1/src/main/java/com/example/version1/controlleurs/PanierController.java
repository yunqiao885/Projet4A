package com.example.version1.controlleurs;

import com.example.version1.DAO.PanierInterface;
import com.example.version1.entities.Avis;
import com.example.version1.entities.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PanierController {
    @Autowired
    private PanierInterface panierInterface;

    @GetMapping(value = "paniers")
    public List<Panier> paniers(){
        return panierInterface.findAll();
    }

    @GetMapping(value = "paniers/{id}")
    public Panier getPanier(@PathVariable int id){
        return panierInterface.findById(id).get();
    }

    @PostMapping(path = "/paniers")
    public Panier save(@RequestBody Panier panier){
        return panierInterface.save(panier);
    }

    @PutMapping("/paniers")
    public Panier update(@RequestBody Panier panier,int id){
        panier.setId(id);
        return panierInterface.save(panier);
    }

    @DeleteMapping("/paniers/{id}")
    public void delete(@PathVariable int id){
        panierInterface.deleteById(id);
    }
}
