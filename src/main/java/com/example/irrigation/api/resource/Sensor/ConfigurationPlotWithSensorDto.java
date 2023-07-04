package com.example.irrigation.api.resource.Sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationPlotWithSensorDto implements Serializable {
    private int plotId;
    private int sensorId;
}
