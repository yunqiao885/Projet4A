package com.example.version1.controlleurs;

import com.example.version1.DAO.BibliothequeInterface;
import com.example.version1.entities.Bibliotheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BibliothequeController {
    @Autowired
    private BibliothequeInterface bibliothequeInterface;

    @GetMapping(value = "categories")
    public List<Bibliotheque> bibliotheques(){
        return bibliothequeInterface.findAll();
    }

    @GetMapping(value = "categories/{id}")
    public Bibliotheque getBibliotheque(@PathVariable int id){
        return bibliothequeInterface.findById(id).get();
    }

    @PostMapping(path = "/categories")
    public Bibliotheque save(@RequestBody Bibliotheque bibliotheque){
        return bibliothequeInterface.save(bibliotheque);
    }

    @PutMapping("/categories")
    public Bibliotheque update(@RequestBody Bibliotheque bibliotheque,int id){
        bibliotheque.setId(id);
        return bibliothequeInterface.save(bibliotheque);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable int id){
        bibliothequeInterface.deleteById(id);
    }
}
