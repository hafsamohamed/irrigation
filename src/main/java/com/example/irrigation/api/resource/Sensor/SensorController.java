package com.example.irrigation.api.resource.Sensor;

import com.example.irrigation.service.PlotService;
import com.example.irrigation.service.SensorService;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import com.example.irrigation.service.util.mapper.SensorMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/sensor",  produces = MediaType.APPLICATION_JSON_VALUE)
public class SensorController {
    private final SensorService sensorService;
    public static SensorMapper SENSOR_MAPPER = SensorMapper.INSTANCE;
    private static final Logger LOGGER = LogManager.getLogger(SensorController.class);

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @GetMapping
    public ResponseEntity<?> getAllSensors(){
//        List<Plot> plots = plotService.getAllPlots();
        List<Sensor> sensors = sensorService.getAllSensors();
//        List<SensorDto> sensorDtos = SENSOR_MAPPER.mapFromListOfSensorToListOfSensorDto(sensors);
        return  new ResponseEntity<>(sensors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addSenor(@RequestBody SensorDto sensorDto){
        LOGGER.error(SENSOR_MAPPER.sensorDtoToEntity(sensorDto) + "editSensor");
        Sensor sensor = sensorService.addSensor(SENSOR_MAPPER.sensorDtoToEntity(sensorDto));
        return new ResponseEntity<>(sensor, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSensor(@PathVariable("id") Integer id){
        Sensor sensor = sensorService.getSensorByID(id);
        SensorDto sensorDto = SENSOR_MAPPER.sensorToDto(sensor);
        return  new ResponseEntity<>(sensor, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> editSensor(@RequestBody SensorDto sensorDto){
        LOGGER.error(SENSOR_MAPPER.sensorDtoToEntity(sensorDto) + "editSensor");
        Sensor sensor = sensorService.editSensor(SENSOR_MAPPER.sensorDtoToEntity(sensorDto));
        return  new ResponseEntity<>(sensor, HttpStatus.OK);
    }
    @PostMapping("/configure")
    public ResponseEntity<?> configurePlot(@RequestBody ConfigurationPlotWithSensorDto configurationPlotWithSensorDto){
        sensorService.addPlotToSensor(configurationPlotWithSensorDto);
        return  new ResponseEntity<>(configurationPlotWithSensorDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<?> getSensorStatus(@PathVariable("id") Integer id){
        boolean state = sensorService.getSensorStatus(id);
        return  new ResponseEntity<>(state, HttpStatus.OK);
    }

    @GetMapping("/{id}/pause")
    public ResponseEntity<?> pauseSensor(@PathVariable("id") Integer id){
        boolean state = sensorService.pauseSensor(id);
        return  new ResponseEntity<>(state, HttpStatus.OK);
    }

    @GetMapping("/{id}/resume")
    public ResponseEntity<?> resumeSensor(@PathVariable("id") Integer id){
        boolean state = sensorService.resumeSensor(id);
        return  new ResponseEntity<>(state, HttpStatus.OK);
    }

}
