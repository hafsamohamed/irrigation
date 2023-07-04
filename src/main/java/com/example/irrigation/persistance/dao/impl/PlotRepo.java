package com.example.irrigation.persistance.dao.impl;

import com.example.irrigation.service.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlotRepo extends JpaRepository<Plot, Integer> {
    Optional<Plot> findById(Integer id);
    List<Plot> findAll();
    @Query("update Plot a set a.status = TRUE  where a.id = :id")
    Optional<Boolean> irrigatePlot(Integer id);


}

