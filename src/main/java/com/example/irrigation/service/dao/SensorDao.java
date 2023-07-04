package com.example.irrigation.service.dao;

import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;

import java.util.Optional;

public interface SensorDao extends GenericCrudDao<Sensor, Integer>{
    void deleteAll();
    Optional<Boolean> findStatusById(Integer id);

}