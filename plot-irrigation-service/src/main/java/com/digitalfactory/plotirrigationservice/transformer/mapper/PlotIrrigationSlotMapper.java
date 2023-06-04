package com.digitalfactory.plotirrigationservice.transformer.mapper;


import com.digitalfactory.baseservice.transformer.mapper.BaseMapper;
import com.digitalfactory.baseservice.transformer.mapper.MapStructCentralConfig;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDTO;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = MapStructCentralConfig.class)
public interface PlotIrrigationSlotMapper extends BaseMapper<PlotIrrigationSlot, PlotIrrigationSlotDTO> {
}
