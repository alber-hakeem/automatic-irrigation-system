package com.digitalfactory.plotirrigationservice.validator;

import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDTO;

public interface PlotIrrigationSlotValidator {
    Boolean isExists(PlotIrrigationSlotDTO plotIrrigationSlotDto);
}
