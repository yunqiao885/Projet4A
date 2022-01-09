package com.example.version2.controller.data;

import com.example.version2.dao.AvisInterface;
import com.example.version2.entities.Avis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @PutMapping("/comments/{id}")
    public Avis update(@RequestBody Avis avis,@PathVariable int id){
        avis.setId(id);
        return avisInterface.save(avis);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable int id){
        avisInterface.deleteById(id);
    }
}
