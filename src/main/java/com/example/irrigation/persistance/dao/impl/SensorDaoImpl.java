package com.example.irrigation.persistance.dao.impl;

import com.example.irrigation.service.dao.SensorDao;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SensorDaoImpl implements SensorDao {

    private final SensorRepo sensorRepo;

    public SensorDaoImpl(SensorRepo sensorRepo) {
        this.sensorRepo = sensorRepo;
    }


    @Override
    public Sensor save(Sensor entity) {
        return sensorRepo.save(entity);
    }

    @Override
    public Sensor update(Sensor entity){
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return sensorRepo.save(entity);
    }

    @Override
    public Optional<Sensor> findById(Integer id) {
        return sensorRepo.findById(id);
    }

    @Override
    public void deleteAll() {
         sensorRepo.deleteAll();
    }

    @Override
    public Optional<Boolean> findStatusById(Integer id){
        return sensorRepo.findStatusById(id);
    }

    @Override
    public List<Sensor> findAll() {

        return sensorRepo.findAll();
    }
}
