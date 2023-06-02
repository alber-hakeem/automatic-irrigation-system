package com.digitalfactory.plotirrigationservice.transformer;

import com.digitalfactory.baseservice.transformer.BaseTransformer;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.model.Plot;
import com.digitalfactory.plotirrigationservice.transformer.mapper.PlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class PlotTransformer implements BaseTransformer<Plot, PlotDto, PlotMapper> {

    private final PlotMapper plotMapper;

    @Override
    public PlotMapper getMapper() {
        return plotMapper;
    }
}
