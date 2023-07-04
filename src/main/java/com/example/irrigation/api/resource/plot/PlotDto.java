package com.example.irrigation.api.resource.plot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotDto implements Serializable {

    private Integer id;

    private double space;

    private double amountOfWater;

    private Boolean status;

    private Boolean sensorStatus;

}
