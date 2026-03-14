package com.agritech.backend.controller;

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
    public Farmer saveFarmer(@RequestBody Farmer farmer){
        return serv.saveFarmer(farmer);
    }

    @GetMapping
    public List<Farmer> getFarmers(){
        return serv.getAllFarmers();
    }
}
