package com.example.irrigation.service.util.mapper;

import com.example.irrigation.api.resource.Sensor.SensorDto;
import com.example.irrigation.api.resource.plot.PlotDto;
import com.example.irrigation.service.entity.Plot;
import com.example.irrigation.service.entity.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {Plot.class })
public interface SensorMapper {

    SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);
    @Mapping(source = "id", target = "id")
    Sensor sensorDtoToEntity(SensorDto sensorDto);

    SensorDto sensorToDto(Sensor sensor);

    public default List<SensorDto> mapFromListOfSensorToListOfSensorDto(List<Sensor> sensors ) {
        return sensors.stream().map(this::sensorToDto).collect( Collectors.toList() );
    }

    public default List<Sensor> mapFromListOfSensorDtoToListOfSensor( List<SensorDto> sensorDtos ) {
        return sensorDtos.stream().map(this::sensorDtoToEntity).collect( Collectors.toList() );
    }
}
