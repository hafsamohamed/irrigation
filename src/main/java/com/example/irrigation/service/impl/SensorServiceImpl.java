package com.example.irrigation.service.impl;

import com.example.irrigation.api.resource.Sensor.ConfigurationPlotWithSensorDto;
import com.example.irrigation.service.SensorService;
import com.example.irrigation.service.dao.PlotDao;
import com.example.irrigation.service.dao.SensorDao;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import com.example.irrigation.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {
    @Autowired
    private final SensorDao sensorDao;
    @Autowired
    private final PlotDao plotDao;

    @Override
    public Sensor editSensor(Sensor sensor) {
        Optional<Sensor> sensor1 = sensorDao.findById(sensor.getId());
        if(sensor1.isPresent())
            return sensorDao.update(sensor);
        throw new ResourceNotFoundException("plot with id " + sensor.getId() + ",not found");
    }

    @Override
    public Sensor addSensor(Sensor sensor) {
        return sensorDao.save(sensor);
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorDao.findAll();
    }

    @Override
    public Sensor getSensorByID(Integer id) {
        return sensorDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("plot with id " + id + ",not found"));
    }

    @Override
    public boolean addPlotToSensor(ConfigurationPlotWithSensorDto configurationPlotWithSensorDto) {
        Sensor sensor = sensorDao.findById(configurationPlotWithSensorDto.getSensorId()).orElseThrow(() -> new ResourceNotFoundException("sensor with id "  + ",not found"));
        Plot plot = plotDao.findById(configurationPlotWithSensorDto.getPlotId()).orElseThrow(() -> new ResourceNotFoundException("plot with id "  + ",not found"));

        sensor.getPlots().add(plot);
        sensorDao.update(sensor);

        plot.setSensor(sensor);
        plotDao.update(plot);

        return true;
    }

    @Override
    public boolean getSensorStatus(Integer id) {
        return sensorDao.findStatusById(id).orElseThrow(() -> new ResourceNotFoundException("sensor with id " + id + ",not found"));
    }
}
