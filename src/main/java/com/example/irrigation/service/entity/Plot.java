package com.example.irrigation.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "plot")
public class Plot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plot_space")
    private double space;

    private double amountOfWater;

    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id")
    @JsonIgnoreProperties("plots")
    private Sensor sensor;

    public Plot(Integer id, double space, double amountOfWater, Boolean status) {
        this.space = space;
        this.amountOfWater = amountOfWater;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "id=" + id +
                ", space=" + space +
                ", amountOfWater=" + amountOfWater +
                ", status=" + status +
                '}';
    }
}
