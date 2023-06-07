package com.digitalfactory.plotirrigationservice.validator;

import com.digitalfactory.plotirrigationservice.dao.PlotCropDao;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class PlotCropValidatorImpl  implements PlotCropValidator{

    private final PlotCropDao plotCropDao;

    @Override
    public Boolean isExists(PlotCropDto plotCropDto) {
        return plotCropDao.isPlotCropExists(plotCropDto);
    }
    @Override
    public Boolean isExistsExcludeId(PlotCropDto plotCropDto) {
        return plotCropDao.isPlotCropExistsExcludeId(plotCropDto);
    }

}
