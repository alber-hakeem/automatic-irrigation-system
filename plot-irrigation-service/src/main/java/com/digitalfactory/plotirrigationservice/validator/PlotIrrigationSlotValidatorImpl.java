package com.digitalfactory.plotirrigationservice.validator;

import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlotIrrigationSlotValidatorImpl implements PlotIrrigationSlotValidator {
    private final PlotIrrigationSlotDao plotIrrigationSlotDao;

    @Override
    public Boolean isExists(PlotIrrigationSlotDto irrigationSlotDto) {
        return plotIrrigationSlotDao.isPlotIrrigationSlotExists(irrigationSlotDto);
    }

    @Override
    public Boolean isExistsExcludeId(PlotIrrigationSlotDto irrigationSlotDto) {
        return plotIrrigationSlotDao.isPlotIrrigationSlotExistsExcludeId(irrigationSlotDto);
    }
}
