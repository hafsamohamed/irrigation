package com.example.irrigation.service;

import com.example.irrigation.api.resource.Sensor.ConfigurationPlotWithSensorDto;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;

import java.util.List;

public interface SensorService {
    public Sensor editSensor(Sensor sensor);
    public Sensor addSensor(Sensor sensor);
    public List<Sensor> getAllSensors();
    public Sensor getSensorByID(Integer id);
    public boolean addPlotToSensor(ConfigurationPlotWithSensorDto configurationPlotWithSensorDto);
    public boolean getSensorStatus(Integer id);

    boolean resumeSensor(Integer id);

    boolean pauseSensor(Integer id);
}
