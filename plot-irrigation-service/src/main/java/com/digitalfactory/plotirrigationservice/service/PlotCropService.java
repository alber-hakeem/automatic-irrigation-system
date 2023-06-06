package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.BaseService;
import com.digitalfactory.plotirrigationservice.dao.PlotCropDao;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import com.digitalfactory.plotirrigationservice.transformer.PlotCropTransformer;


public interface PlotCropService extends BaseService<PlotCrop, PlotCropDto, PlotCropTransformer, PlotCropDao> {
}
