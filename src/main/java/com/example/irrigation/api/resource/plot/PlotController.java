package com.example.irrigation.api.resource.plot;

import com.example.irrigation.service.PlotService;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.util.mapper.PlotMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/plot",  produces = MediaType.APPLICATION_JSON_VALUE)
public class PlotController {
    private final PlotService plotService;
    public static PlotMapper PLOT_MAPPER = PlotMapper.INSTANCE;
    private static final Logger LOGGER = LogManager.getLogger(PlotController.class);

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPlots(){
        List<Plot> plots = plotService.getAllPlots();
        List<PlotDto> plotDtos = PLOT_MAPPER.mapFromListOfPlotToListOfPlotDto(plots);
        return  new ResponseEntity<>(plotDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addPlot(@RequestBody PlotDto plotDto){
        LOGGER.error(PLOT_MAPPER.plotDtoToEntity(plotDto) + "editPlot");
        Plot plot = plotService.addPlot(PLOT_MAPPER.plotDtoToEntity(plotDto));
        return new ResponseEntity<>(plot, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPlot(@PathVariable("id") Integer id){
        Plot plot = plotService.getPlotByID(id);
        PlotDto plotDto = PLOT_MAPPER.plotToDto(plot);
        return  new ResponseEntity<>(plotDto, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> editPlot(@RequestBody PlotDto plotDto){
        LOGGER.error(PLOT_MAPPER.plotDtoToEntity(plotDto) + "editPlot");
        Plot plot = plotService.editPlot(PLOT_MAPPER.plotDtoToEntity(plotDto));
        return  new ResponseEntity<>(plot, HttpStatus.OK);
    }

    @GetMapping("/irrigate/{id}")
    public ResponseEntity<?> irrigatePlot(@PathVariable("id") Integer id){
        boolean state = plotService.irrigatePlot(id);
        return  new ResponseEntity<>(state, HttpStatus.OK);
    }

}
