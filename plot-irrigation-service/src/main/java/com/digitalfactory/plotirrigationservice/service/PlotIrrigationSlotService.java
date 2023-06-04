package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.BaseService;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDTO;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import com.digitalfactory.plotirrigationservice.transformer.PlotIrrigationSlotTransformer;


public interface PlotIrrigationSlotService extends BaseService<PlotIrrigationSlot, PlotIrrigationSlotDTO, PlotIrrigationSlotTransformer, PlotIrrigationSlotDao> {
}
