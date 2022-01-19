package com.example.version2.controller.data;

import com.example.version2.dao.AdministrateurInterface;
import com.example.version2.entities.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdministrateurController {

    @Autowired
    private AdministrateurInterface administrateurInterface;

    @GetMapping(value = "admins")
    public List<Administrateur> admins(){
        return administrateurInterface.findAll();
    }

    @GetMapping(value = "admins/{id}")
    public Administrateur getAdmin(@PathVariable int id){
        return administrateurInterface.findById(id).get();
    }

    @PostMapping(path = "/admins")
    public Administrateur save(@RequestBody Administrateur administrateur){
        return administrateurInterface.save(administrateur);
    }

    @PutMapping("/admins/{id}")
    public Administrateur update(@RequestBody Administrateur administrateur, @PathVariable int id){
        administrateur.setId(id);
        return administrateurInterface.save(administrateur);
    }

    @DeleteMapping("/admins/{id}")
    public void delete(@PathVariable int id){
        administrateurInterface.deleteById(id);
    }
}
