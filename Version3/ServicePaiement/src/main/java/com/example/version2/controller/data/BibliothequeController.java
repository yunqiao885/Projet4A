package com.example.version2.controller.data;

import com.example.version2.dao.BibliothequeInterface;
import com.example.version2.entities.Bibliotheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BibliothequeController {

    @Autowired
    private BibliothequeInterface bibliothequeInterface;

    @GetMapping(value = "biblios")
    public List<Bibliotheque> bibliotheques(){
        return bibliothequeInterface.findAll();
    }

    @GetMapping("biblios/{id}")
    public Bibliotheque getBibliotheque(@PathVariable int id){
        return bibliothequeInterface.findById(id).get();
    }

    @PostMapping(path = "/biblios")
    public Bibliotheque save(@RequestBody Bibliotheque bibliotheque){
        return bibliothequeInterface.save(bibliotheque);
    }

    @PutMapping("/biblios/{id}")
    public Bibliotheque update(@RequestBody Bibliotheque bibliotheque,@PathVariable int id){
        bibliotheque.setId(id);
        return bibliothequeInterface.save(bibliotheque);
    }

    @DeleteMapping("/biblios/{id}")
    public void delete(@PathVariable int id){
        bibliothequeInterface.deleteById(id);
    }
}
