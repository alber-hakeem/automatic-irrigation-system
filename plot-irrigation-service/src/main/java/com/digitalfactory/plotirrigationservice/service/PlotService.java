package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.BaseService;
import com.digitalfactory.plotirrigationservice.dao.PlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.model.Plot;
import com.digitalfactory.plotirrigationservice.transformer.PlotTransformer;


public interface PlotService extends BaseService<Plot, PlotDto, PlotTransformer, PlotDao> {
}
