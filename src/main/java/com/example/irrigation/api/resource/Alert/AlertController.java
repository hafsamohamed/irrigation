package com.example.irrigation.api.resource.Alert;

import com.example.irrigation.service.AlertService;
import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.util.mapper.AlertMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/alert",  produces = MediaType.APPLICATION_JSON_VALUE)
public class AlertController {
    private final AlertService alertService;
    public static AlertMapper ALERT_MAPPER = AlertMapper.INSTANCE;
    private static final Logger LOGGER = LogManager.getLogger(AlertController.class);

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }


    @GetMapping
    public ResponseEntity<?> getAllAlerts(){
        List<Alert> alerts = alertService.getAllAlerts();
        List<AlertDto> alertDtos = ALERT_MAPPER.mapFromListOfAlertToListOfAlertDto(alerts);
        return  new ResponseEntity<>(alertDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addAlert(@RequestBody AlertDto alertDto){
        LOGGER.error(ALERT_MAPPER.alertDtoToEntity(alertDto) + "editPlot");
        Alert alert = alertService.addAlert(ALERT_MAPPER.alertDtoToEntity(alertDto));
        return new ResponseEntity<>(alert, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAlert(@PathVariable("id") Integer id){
        Alert alert = alertService.getAlertById(id);
        AlertDto alertDto = ALERT_MAPPER.alertToDto(alert);
        return  new ResponseEntity<>(alertDto, HttpStatus.OK);
    }


}
