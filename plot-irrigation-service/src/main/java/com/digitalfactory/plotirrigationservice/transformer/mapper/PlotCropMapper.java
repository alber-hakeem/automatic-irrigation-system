package com.digitalfactory.plotirrigationservice.transformer.mapper;

import com.digitalfactory.baseservice.transformer.mapper.BaseMapper;
import com.digitalfactory.baseservice.transformer.mapper.MapStructCentralConfig;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDTO;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = MapStructCentralConfig.class,uses = {PlotMapper.class,CropMapper.class})
public interface PlotCropMapper extends BaseMapper<PlotCrop, PlotCropDTO> {
}
