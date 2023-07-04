package com.example.irrigation.api.resource.Sensor;

import com.example.irrigation.service.entity.Plot;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto implements Serializable {
    private Integer id;
    private boolean state;
    private double irrigationPeriod;
    private List<Plot> plots;
}
