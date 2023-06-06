package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.BaseService;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import com.digitalfactory.plotirrigationservice.transformer.PlotIrrigationSlotTransformer;

import java.util.List;
import java.util.Set;


public interface PlotIrrigationSlotService extends BaseService<PlotIrrigationSlot, PlotIrrigationSlotDto, PlotIrrigationSlotTransformer, PlotIrrigationSlotDao> {

    List<PlotIrrigationSlotDto> updateIrrigationSlots(Long plotId, Set<PlotIrrigationSlotDto> plotSlotDtos);

    List<PlotIrrigationSlotDto> findAllByPlotCropId(Long plotCropId);

}
