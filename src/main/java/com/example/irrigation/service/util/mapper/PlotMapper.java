package com.example.irrigation.service.util.mapper;

import com.example.irrigation.api.resource.plot.PlotDto;
import com.example.irrigation.service.entity.Plot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PlotMapper {

    PlotMapper INSTANCE = Mappers.getMapper(PlotMapper.class);
    @Mapping(source = "id", target = "id")
    Plot plotDtoToEntity(PlotDto plotDto);

    PlotDto plotToDto(Plot plot);

    public default List<PlotDto> mapFromListOfPlotToListOfPlotDto(List<Plot> plots ) {
        return plots.stream().map(this::plotToDto).collect( Collectors.toList() );
    }

    public default List<Plot> mapFromListOfPlotDtoToListOfPlot( List<PlotDto> plotDtos ) {
        return plotDtos.stream().map(this::plotDtoToEntity).collect( Collectors.toList() );
    }
}
