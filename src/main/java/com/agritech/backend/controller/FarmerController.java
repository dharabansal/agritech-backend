package com.agritech.backend.controller;

import com.agritech.backend.dto.Farmerdto;
import com.agritech.backend.model.Farmer;
import com.agritech.backend.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService serv;

    @PostMapping
    public Farmer saveFarmer(@RequestBody Farmerdto farmerdto){
        return serv.saveFarmer(farmerdto);
    }

    @GetMapping
    public List<Farmer> getFarmers(){
        return serv.getAllFarmers();
    }

    @PutMapping("/{id}")
    public Farmer updateFarmer(@PathVariable Long id, @RequestBody Farmer farmer){
        return serv.updateFarmer(id,farmer);
    }

    @DeleteMapping("/{id}")
    public void deleteFarmer(@PathVariable Long id){
        serv.deleteFarmer(id);
    }
}
