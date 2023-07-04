package com.example.irrigation.service.util.mapper;

import com.example.irrigation.api.resource.plot.PlotDto;
import com.example.irrigation.service.entity.Plot;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-04T00:45:14+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class PlotMapperImpl implements PlotMapper {

    @Override
    public Plot plotDtoToEntity(PlotDto plotDto) {
        if ( plotDto == null ) {
            return null;
        }

        Plot plot = new Plot();

        plot.setId( plotDto.getId() );
        plot.setSpace( plotDto.getSpace() );
        plot.setAmountOfWater( plotDto.getAmountOfWater() );
        plot.setStatus( plotDto.getStatus() );

        return plot;
    }

    @Override
    public PlotDto plotToDto(Plot plot) {
        if ( plot == null ) {
            return null;
        }

        PlotDto plotDto = new PlotDto();

        plotDto.setId( plot.getId() );
        plotDto.setSpace( plot.getSpace() );
        plotDto.setAmountOfWater( plot.getAmountOfWater() );
        plotDto.setStatus( plot.getStatus() );

        return plotDto;
    }
}
