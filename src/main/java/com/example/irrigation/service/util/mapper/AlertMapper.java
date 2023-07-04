package com.example.irrigation.service.util.mapper;

import com.example.irrigation.api.resource.Alert.AlertDto;
import com.example.irrigation.api.resource.plot.PlotDto;
import com.example.irrigation.service.entity.Alert;
import com.example.irrigation.service.entity.Plot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface AlertMapper {

    AlertMapper INSTANCE = Mappers.getMapper(AlertMapper.class);
    Alert alertDtoToEntity(AlertDto alertDto);

    AlertDto alertToDto(Alert alert);

    public default List<AlertDto> mapFromListOfAlertToListOfAlertDto(List<Alert> alerts ) {
        return alerts.stream().map(this::alertToDto).collect( Collectors.toList() );
    }

    public default List<Alert> mapFromListOfAlertDtoToListOfAlert( List<AlertDto> alertDtos ) {
        return alertDtos.stream().map(this::alertDtoToEntity).collect( Collectors.toList() );
    }
}
