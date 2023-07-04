package com.example.irrigation.persistance.dao.impl;

import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlertRepo extends JpaRepository<Alert, Integer> {
    Optional<Alert> findById(Integer id);
    List<Alert> findAll();


}

