package com.example.irrigation.persistance.dao.impl;

import com.example.irrigation.service.dao.PlotDao;
import com.example.irrigation.service.entity.Plot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlotDaoImpl implements PlotDao {

    private final PlotRepo plotRepo;

    public PlotDaoImpl(PlotRepo accountRepo) {
        this.plotRepo = accountRepo;
    }


    @Override
    public Plot save(Plot entity) {
        return plotRepo.save(entity);
    }

    @Override
    public Plot update(Plot entity){
        if (entity == null || entity.getId() == null){
            throw new NullPointerException("entity or id can't be null");
        }
        return plotRepo.save(entity);
    }

    @Override
    public Optional<Plot> findById(Integer id) {
        return plotRepo.findById(id);
    }

    @Override
    public void deleteAll() {
         plotRepo.deleteAll();
    }

    @Override
    public Optional<Boolean> irrigatePlot(Integer id) {
        return plotRepo.irrigatePlot(id);
    }

    @Override
    public List<Plot> findAll() {
        return plotRepo.findAll();
    }
}
