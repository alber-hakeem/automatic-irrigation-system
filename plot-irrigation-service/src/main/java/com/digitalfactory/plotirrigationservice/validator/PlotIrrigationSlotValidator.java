package com.digitalfactory.plotirrigationservice.validator;

import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;

public interface PlotIrrigationSlotValidator {
    Boolean isExists(PlotIrrigationSlotDto plotIrrigationSlotDto);
    Boolean isExistsExcludeId(PlotIrrigationSlotDto irrigationSlotDto);

}
