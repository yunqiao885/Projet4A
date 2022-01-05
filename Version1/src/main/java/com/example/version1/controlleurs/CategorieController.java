package com.example.version1.controlleurs;

import com.example.version1.DAO.CategorieInterface;
import com.example.version1.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategorieController {
    @Autowired
    private CategorieInterface categorieInterface;

    @GetMapping(value = "categories")
    public List<Categorie> categories(){
        return categorieInterface.findAll();
    }

    @GetMapping(value = "categories/{id}")
    public Categorie getCategorie(@PathVariable int id){
        return categorieInterface.findById(id).get();
    }

    @PostMapping(path = "/categories")
    public Categorie save(@RequestBody Categorie categorie){
        return categorieInterface.save(categorie);
    }

    @PutMapping("/categories")
    public Categorie update(@RequestBody Categorie categorie,int id){
        categorie.setId(id);
        return categorieInterface.save(categorie);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable int id){
        categorieInterface.deleteById(id);
    }
}
