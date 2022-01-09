package com.example.version2.controller.data;

import com.example.version2.dao.PayementInterface;
import com.example.version2.entities.Payement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PaiementController {
    @Autowired
    private PayementInterface payementInterface;

    @GetMapping(value = "paiements")
    public List<Payement> payements(){
        return payementInterface.findAll();
    }

    @GetMapping(value = "paiements/{no_payement}")
    public Payement getPayement(@PathVariable int no_payement){
        return payementInterface.findById(no_payement).get();
    }

    @PostMapping(path = "/paiements")
    public Payement save(@RequestBody Payement payement){
        return payementInterface.save(payement);
    }

    @PutMapping("/paiements/{no_payement}")
    public Payement update(@RequestBody Payement payement,@PathVariable int no_payement){
        payement.setNo_payement(no_payement);
        return payementInterface.save(payement);
    }

    @DeleteMapping("/paiements/{id}")
    public void delete(@PathVariable int id){
        payementInterface.deleteById(id);
    }
}
