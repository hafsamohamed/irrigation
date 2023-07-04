package com.example.irrigation.api.resource.Alert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertDto implements Serializable {

    private Integer id;
    private int sensorId;
    private Timestamp time;

}
