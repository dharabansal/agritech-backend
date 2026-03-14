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

    public Farmer updateFarmer(Long id, Farmer newFarmer){
        Farmer existing = repo.findById(id).orElseThrow();
        existing.setName(newFarmer.getName());
        existing.setVillage(newFarmer.getVillage());
        existing.setCrop(newFarmer.getCrop());
        return repo.save(existing);
    }

    public void deleteFarmer(Long id){
        repo.deleteById(id);
    }

}
