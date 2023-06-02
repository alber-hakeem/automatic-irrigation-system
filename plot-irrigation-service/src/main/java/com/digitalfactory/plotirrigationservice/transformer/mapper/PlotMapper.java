package com.digitalfactory.plotirrigationservice.transformer.mapper;


import com.digitalfactory.baseservice.transformer.mapper.BaseMapper;
import com.digitalfactory.baseservice.transformer.mapper.MapStructCentralConfig;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.model.Plot;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = MapStructCentralConfig.class)
public interface PlotMapper extends BaseMapper<Plot, PlotDto> {

}
