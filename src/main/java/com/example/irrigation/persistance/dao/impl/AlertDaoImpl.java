package com.example.irrigation.persistance.dao.impl;

import com.example.irrigation.service.dao.AlertDao;
import com.example.irrigation.service.dao.PlotDao;
import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlertDaoImpl implements AlertDao {

    private final AlertRepo alertRepo;

    public AlertDaoImpl(AlertRepo alertRepo) {
        this.alertRepo = alertRepo;
    }

    @Override
    public Alert save(Alert entity) {
        return alertRepo.save(entity);
    }

    @Override
    public Alert update(Alert entity){
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return alertRepo.save(entity);
    }

    @Override
    public Optional<Alert> findById(Integer id) {
        return alertRepo.findById(id);
    }

    @Override
    public void deleteAll() {
         alertRepo.deleteAll();
    }

    @Override
    public List<Alert> findAll() {
        return alertRepo.findAll();
    }
}
