package com.agritech.backend.service;

import com.agritech.backend.model.Farmer;
import com.agritech.backend.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository repo;

    public Farmer saveFarmer(Farmer farmer){
        return repo.save(farmer);
    }

    public List<Farmer> getAllFarmers(){
        return repo.findAll();
    }

}
