package com.example.irrigation.service.entity;

import com.example.irrigation.service.entity.Plot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean state;
    private double irrigationPeriod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sensor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("sensor")
    private List<Plot> plots;

    public Sensor(Integer id, boolean state, double irrigationPeriod) {
        this.id = id;
        this.state = state;
        this.irrigationPeriod = irrigationPeriod;
    }
}
