package com.digitalfactory.plotirrigationservice.transformer.mapper;


import com.digitalfactory.baseservice.transformer.mapper.BaseMapper;
import com.digitalfactory.baseservice.transformer.mapper.MapStructCentralConfig;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = MapStructCentralConfig.class)
public interface PlotIrrigationSlotMapper extends BaseMapper<PlotIrrigationSlot, PlotIrrigationSlotDto> {

    @Override
    @Mapping(target = "plotCrop.plotIrrigationSlots", ignore = true)
    PlotIrrigationSlotDto entityToDto(PlotIrrigationSlot entity);

    @Named(value = "mapWithoutPlotCrop")
    @Mapping(target = "plotCrop", ignore = true)
    PlotIrrigationSlotDto mapWithoutPlotCrop(PlotIrrigationSlot entity);

    @Named("mapListWithoutPlotCrop")
    @IterableMapping(qualifiedByName = "mapWithoutPlotCrop")
    List<PlotIrrigationSlotDto> mapListWithoutPlotCrop(List<PlotIrrigationSlot> entities);

}
