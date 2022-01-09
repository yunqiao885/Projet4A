package com.example.version2.controller.data;

import com.example.version2.dao.PanierInterface;
import com.example.version2.entities.Jeu;
import com.example.version2.entities.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @PutMapping("/paniers/{id}")
    public Panier update(@RequestBody Panier panier, @PathVariable int id){
        panier.setId(id);
        int total = 0;
        for (Jeu jeu: panier.getJeux()) {
            total+= jeu.getPrix();
        }
        panier.setPrix_total(total);
        return panierInterface.save(panier);
    }

    @DeleteMapping("/paniers/{id}")
    public void delete(@PathVariable int id){
        panierInterface.deleteById(id);
    }
}
