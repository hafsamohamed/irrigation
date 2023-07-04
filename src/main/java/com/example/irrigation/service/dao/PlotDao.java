package com.example.irrigation.service.dao;


import com.example.irrigation.service.entity.Plot;

import java.util.Optional;

public interface PlotDao extends GenericCrudDao<Plot, Integer>{
    void deleteAll();
    Optional<Boolean> irrigatePlot(Integer id);
}