package com.example.irrigation.service.util.mapper;

import com.example.irrigation.api.resource.Sensor.SensorDto;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-04T13:58:06+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class SensorMapperImpl implements SensorMapper {

    private final Plot plot = new Plot();

    @Override
    public Sensor sensorDtoToEntity(SensorDto sensorDto) {
        if ( sensorDto == null ) {
            return null;
        }

        Sensor sensor = plot.getSensor();

        sensor.setId( sensorDto.getId() );
        sensor.setState( sensorDto.isState() );
        sensor.setIrrigationPeriod( sensorDto.getIrrigationPeriod() );
        List<Plot> list = sensorDto.getPlots();
        if ( list != null ) {
            sensor.setPlots( new ArrayList<Plot>( list ) );
        }

        return sensor;
    }

    @Override
    public SensorDto sensorToDto(Sensor sensor) {
        if ( sensor == null ) {
            return null;
        }

        SensorDto sensorDto = new SensorDto();

        sensorDto.setId( sensor.getId() );
        sensorDto.setState( sensor.isState() );
        sensorDto.setIrrigationPeriod( sensor.getIrrigationPeriod() );
        List<Plot> list = sensor.getPlots();
        if ( list != null ) {
            sensorDto.setPlots( new ArrayList<Plot>( list ) );
        }

        return sensorDto;
    }
}
