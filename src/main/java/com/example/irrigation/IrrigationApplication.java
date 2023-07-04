package com.example.irrigation;

import com.example.irrigation.service.dao.AlertDao;
import com.example.irrigation.service.dao.PlotDao;
import com.example.irrigation.service.dao.SensorDao;
import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;

@SpringBootApplication
public class IrrigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrrigationApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(PlotDao plotRepo, SensorDao sensorDao, AlertDao alertDao){
		return ars -> {
			Plot plot = new Plot(10001, 10.0, 2.5, false);
			Plot plot1 = new Plot(10002, 20.0, 5, false);
			Plot plot2 = new Plot(10003, 30.0, 10, false);

			Sensor sensor = new Sensor(10001, true, 3.0);
			Sensor sensor1 = new Sensor(10002, true, 2.0);


			Sensor sensor2 = sensorDao.save(sensor);
			Sensor sensor3 = sensorDao.save(sensor1);

			plot.setSensor(sensor2);
			plot1.setSensor(sensor2);
			plot2.setSensor(sensor3);

			sensor2.setPlots(List.of(plot, plot1));
			sensor3.setPlots(List.of(plot2));

			plotRepo.save(plot);
			plotRepo.save(plot1);
			plotRepo.save(plot2);

			System.out.println(sensor2.getPlots() + "hena+++aaaaa");

			Alert alert = new Alert(10001, sensor2.getId(), new Timestamp(System.currentTimeMillis()));
			alertDao.save(alert);

		};

	}
}
