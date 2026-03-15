package com.agritech.backend.service;

import com.agritech.backend.dto.Farmerdto;
import com.agritech.backend.exception.ResourceNotFoundException;
import com.agritech.backend.model.Farmer;
import com.agritech.backend.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository repo;

    public Farmerdto saveFarmer(Farmerdto farmerdto){
        Farmer farmer = new Farmer();
        farmer.setCrop(farmerdto.getCrop());
        farmer.setId(farmerdto.getId());
        farmer.setName(farmerdto.getName());
        farmer.setVillage(farmerdto.getVillage());
        Farmer newfarmer = repo.save(farmer);
        Farmerdto farmer1 = new Farmerdto();
        farmer1.setId(newfarmer.getId());
        farmer1.setCrop(newfarmer.getCrop());
        farmer1.setName(newfarmer.getName());
        farmer1.setVillage(newfarmer.getVillage());
        return farmer1;
    }

    public List<Farmerdto> getAllFarmers(){
        List<Farmer> l = repo.findAll();
        return l.stream().map(farmer -> {Farmerdto dto = new Farmerdto();
            dto.setId(farmer.getId());
            dto.setName(farmer.getName());
            dto.setCrop(farmer.getCrop());
            dto.setVillage(farmer.getVillage());return dto; }).collect(Collectors.toList());
    }

    public Farmerdto getFarmerById(Long id){
        Farmer existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farmer not found with" + id));
        Farmerdto data = new Farmerdto();
        data.setCrop(existing.getCrop());
        data.setId(existing.getId());
        data.setName(existing.getName());
        data.setVillage(existing.getVillage());
        return data;
    }

    public Farmerdto updateFarmer(Long id, Farmerdto newFarmer){
        Farmer existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farmer not found with" + id));
        existing.setName(newFarmer.getName());
        existing.setVillage(newFarmer.getVillage());
        existing.setCrop(newFarmer.getCrop());
        Farmer newFarmer1 = repo.save(existing);
        Farmerdto dto = new Farmerdto();
        dto.setId(newFarmer1.getId());
        dto.setVillage(newFarmer1.getVillage());
        dto.setName(newFarmer1.getName());
        dto.setCrop(newFarmer1.getCrop());
        return dto;
    }

    public String deleteFarmer(Long id){
       Farmer fm = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farmer not found with" + id));
       repo.delete(fm);
       return "Farmer deleted successfully with id " + id ;

    }

}
