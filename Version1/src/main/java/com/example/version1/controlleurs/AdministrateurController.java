package com.example.version1.controlleurs;

import com.example.version1.DAO.AdministrateurInterface;
import com.example.version1.entities.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AdministrateurController {
    @Autowired
    private AdministrateurInterface administrateurInterface;

    @GetMapping(value = "categories")
    public List<Administrateur> admins(){
        return administrateurInterface.findAll();
    }

    @GetMapping(value = "categories/{id}")
    public Administrateur getAdmin(@PathVariable int id){
        return administrateurInterface.findById(id).get();
    }

    @PostMapping(path = "/categories")
    public Administrateur save(@RequestBody Administrateur administrateur){
        return administrateurInterface.save(administrateur);
    }

    @PutMapping("/categories")
    public Administrateur update(@RequestBody Administrateur administrateur,int id){
        administrateur.setId(id);
        return administrateurInterface.save(administrateur);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable int id){
        administrateurInterface.deleteById(id);
    }
}
