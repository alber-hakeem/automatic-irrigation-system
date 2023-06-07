package com.digitalfactory.plotirrigationservice.dao;


import com.digitalfactory.baseservice.dao.BaseDao;
import com.digitalfactory.plotirrigationservice.dao.repo.PlotCropRepo;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import org.springframework.stereotype.Component;

@Component
public interface PlotCropDao extends BaseDao<PlotCrop, PlotCropRepo> {
    Boolean isPlotCropExists(PlotCropDto plotCropDto);
    Boolean isPlotCropExistsExcludeId(PlotCropDto plotCropDto);

}
