package com.example.version1.controlleurs;

import com.example.version1.DAO.PayementInterface;
import com.example.version1.entities.Payement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PayementController {
    @Autowired
    private PayementInterface payementInterface;

    @GetMapping(value = "categories")
    public List<Payement> payements(){
        return payementInterface.findAll();
    }

    @GetMapping(value = "categories/{no_payement}")
    public Payement getPayement(@PathVariable int no_payement){
        return payementInterface.findById(no_payement).get();
    }

    @PostMapping(path = "/categories")
    public Payement save(@RequestBody Payement payement){
        return payementInterface.save(payement);
    }

    @PutMapping("/categories")
    public Payement update(@RequestBody Payement payement,int no_payement){
        payement.setNo_payement(no_payement);
        return payementInterface.save(payement);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable int id){
        payementInterface.deleteById(id);
    }
}
