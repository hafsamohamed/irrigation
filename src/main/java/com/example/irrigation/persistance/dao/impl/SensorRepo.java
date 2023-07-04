package com.example.irrigation.persistance.dao.impl;

import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SensorRepo extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findById(Integer id);
    List<Sensor> findAll();

    @Query("select a.state from Sensor a where a.id = :id")
    Optional<Boolean> findStatusById(Integer id);

}

