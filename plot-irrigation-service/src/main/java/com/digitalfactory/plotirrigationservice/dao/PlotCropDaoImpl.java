package com.digitalfactory.plotirrigationservice.dao;


import com.digitalfactory.plotirrigationservice.dao.repo.PlotCropRepo;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlotCropDaoImpl implements PlotCropDao{

    private final PlotCropRepo plotCropRepo;


    @Override
    public Boolean isPlotCropExists(PlotCropDto plotCropDto) {
        return getRepository().findCountPerPlotAndCrop(plotCropDto.getPlotId(), plotCropDto.getCropId(),
                plotCropDto.getStartDate(), plotCropDto.getEndDate()) > 0;
    }

    @Override
    public Boolean isPlotCropExistsExcludeId(PlotCropDto plotCropDto) {
        return getRepository().findCountPerPlotAndCropExcludeId(plotCropDto.getId(), plotCropDto.getPlotId(),
                plotCropDto.getCropId(), plotCropDto.getStartDate(), plotCropDto.getEndDate()) > 0;
    }

    @Override
    public PlotCropRepo getRepository() {
        return plotCropRepo;
    }
}
