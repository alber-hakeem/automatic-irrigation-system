package com.digitalfactory.plotirrigationservice.transformer.mapper;

import com.digitalfactory.baseservice.transformer.mapper.BaseMapper;
import com.digitalfactory.baseservice.transformer.mapper.MapStructCentralConfig;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = MapStructCentralConfig.class,uses = {PlotMapper.class,CropMapper.class,PlotIrrigationSlotMapper.class})
public interface PlotCropMapper extends BaseMapper<PlotCrop, PlotCropDto> {
    @Override
    @Mapping(target = "plotIrrigationSlots", qualifiedByName = "mapListWithoutPlotCrop")
    PlotCropDto entityToDto(PlotCrop entity);

}
