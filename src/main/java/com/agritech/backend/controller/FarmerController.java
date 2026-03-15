package com.agritech.backend.controller;

import com.agritech.backend.dto.Farmerdto;
import com.agritech.backend.model.Farmer;
import com.agritech.backend.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService serv;

    @PostMapping
    public ResponseEntity<Farmerdto> saveFarmer(@RequestBody Farmerdto farmerdto){
        return ResponseEntity.ok(serv.saveFarmer(farmerdto));
    }

    @GetMapping
    public ResponseEntity<List<Farmerdto>> getFarmers(){
        return ResponseEntity.ok(serv.getAllFarmers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmerdto> getFarmerById(@PathVariable Long id){
        return ResponseEntity.ok(serv.getFarmerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmerdto> updateFarmer(@PathVariable Long id, @RequestBody Farmerdto farmerdto){
        return ResponseEntity.ok(serv.updateFarmer(id,farmerdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable Long id){
        return ResponseEntity.ok(serv.deleteFarmer(id));
    }
}
