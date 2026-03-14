package com.agritech.backend.repository;

import com.agritech.backend.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer,Long> {

}
