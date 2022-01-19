package com.example.version2.controller.data;

import com.example.version2.dao.ModePayementInterface;
import com.example.version2.entities.ModePayement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModePayementController {
    @Autowired
    private ModePayementInterface modePayementInterface;

    @GetMapping(value = "modePaiement")
    public List<ModePayement> modes(){
        return modePayementInterface.findAll();
    }

    @GetMapping(value = "modePaiement/{id}")
    public ModePayement getModePayement(@PathVariable int id){
        return modePayementInterface.findById(id).get();
    }

    @PostMapping(path = "/modePaiement")
    public ModePayement save(@RequestBody ModePayement modePayement){
        return modePayementInterface.save(modePayement);
    }

    @PutMapping("/modePaiement/{id}")
    public ModePayement update(@RequestBody ModePayement modePayement, @PathVariable int id){
        modePayement.setId(id);
        return modePayementInterface.save(modePayement);
    }

    @DeleteMapping("/modePaiement/{id}")
    public void delete(@PathVariable int id){
        modePayementInterface.deleteById(id);
    }
}
