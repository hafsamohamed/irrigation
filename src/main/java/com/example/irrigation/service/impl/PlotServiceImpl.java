package com.example.irrigation.service.impl;

import com.example.irrigation.api.resource.plot.PlotController;
import com.example.irrigation.api.resource.plot.PlotDto;
import com.example.irrigation.service.PlotService;
import com.example.irrigation.service.dao.PlotDao;
import com.example.irrigation.service.entity.Plot;

import com.example.irrigation.service.exception.ResourceAlreadyExistException;
import com.example.irrigation.service.exception.ResourceNotFoundException;
import com.example.irrigation.service.util.mapper.PlotMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlotServiceImpl implements PlotService {
    @Autowired
    private final PlotDao plotDao;

    @Override
    public Plot editPlot(Plot plot) {
        Optional<Plot> plot1 = plotDao.findById(plot.getId());
        if(plot1.isPresent())
            return plotDao.update(plot);
        throw new ResourceNotFoundException("plot with id " + plot.getId() + ",not found");

    }

    @Override
    public Plot addPlot(Plot plot) {
        return plotDao.save(plot);
    }

    @Override
    public List<Plot> getAllPlots() {
        return plotDao.findAll();
    }

    @Override
    public Plot getPlotByID(Integer id) {
        return plotDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("plot with id " + id + ",not found"));

    }

    @Override
    public boolean irrigatePlot(Integer id) {
        Plot plot = plotDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("plot with id " + id + ",not found"));
        plot.setStatus(true);
        plotDao.update(plot);
        return true;
    }
}
