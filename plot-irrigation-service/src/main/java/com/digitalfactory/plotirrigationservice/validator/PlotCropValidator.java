package com.digitalfactory.plotirrigationservice.validator;


import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;

public interface PlotCropValidator {
    Boolean isExists(PlotCropDto plotCropDto);
    Boolean isExistsExcludeId(PlotCropDto plotCropDto);

}
