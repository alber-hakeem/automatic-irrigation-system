package com.digitalfactory.plotirrigationservice.transformer;

import com.digitalfactory.baseservice.transformer.BaseTransformer;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import com.digitalfactory.plotirrigationservice.transformer.mapper.PlotIrrigationSlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class PlotIrrigationSlotTransformer implements BaseTransformer<PlotIrrigationSlot, PlotIrrigationSlotDto, PlotIrrigationSlotMapper> {

    private final PlotIrrigationSlotMapper plotIrrigationSlotMapper;

    @Override
    public PlotIrrigationSlotMapper getMapper() {
        return plotIrrigationSlotMapper;
    }
}
