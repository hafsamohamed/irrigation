package com.example.irrigation.service.util.mapper;

import com.example.irrigation.api.resource.Alert.AlertDto;
import com.example.irrigation.service.entity.Alert;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-04T00:45:14+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class AlertMapperImpl implements AlertMapper {

    @Override
    public Alert alertDtoToEntity(AlertDto alertDto) {
        if ( alertDto == null ) {
            return null;
        }

        Alert alert = new Alert();

        alert.setId( alertDto.getId() );
        alert.setSensorId( alertDto.getSensorId() );
        alert.setTime( alertDto.getTime() );

        return alert;
    }

    @Override
    public AlertDto alertToDto(Alert alert) {
        if ( alert == null ) {
            return null;
        }

        AlertDto alertDto = new AlertDto();

        alertDto.setId( alert.getId() );
        alertDto.setSensorId( alert.getSensorId() );
        alertDto.setTime( alert.getTime() );

        return alertDto;
    }
}
