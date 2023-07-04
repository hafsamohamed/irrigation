package com.example.irrigation.api.resource.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorSimulator {
    private int numberOfRequests;
    private boolean requestStatus;
}
