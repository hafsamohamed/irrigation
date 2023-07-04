package com.example.irrigation.service;

import com.example.irrigation.api.resource.plot.PlotDto;
import com.example.irrigation.service.entity.Plot;

import java.util.List;

public interface PlotService {
    public Plot editPlot(Plot plot);
    public Plot addPlot(Plot plot);
    public List<Plot> getAllPlots();
    public Plot getPlotByID(Integer id);
    public boolean irrigatePlot(Integer id);
}
