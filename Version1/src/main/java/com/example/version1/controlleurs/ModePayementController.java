package com.example.version1.controlleurs;

import com.example.version1.DAO.ModePayementInterface;
import com.example.version1.entities.ModePayement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ModePayementController {
    @Autowired
    private ModePayementInterface modePayementInterface;

    @GetMapping(value = "categories")
    public List<ModePayement> modes(){
        return modePayementInterface.findAll();
    }

    @GetMapping(value = "categories/{id}")
    public ModePayement getModePayement(@PathVariable int id){
        return modePayementInterface.findById(id).get();
    }

    @PostMapping(path = "/categories")
    public ModePayement save(@RequestBody ModePayement modePayement){
        return modePayementInterface.save(modePayement);
    }

    @PutMapping("/categories")
    public ModePayement update(@RequestBody ModePayement modePayement, int id){
        modePayement.setId(id);
        return modePayementInterface.save(modePayement);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable int id){
        modePayementInterface.deleteById(id);
    }
}
