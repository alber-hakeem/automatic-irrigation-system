package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDTO;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import com.digitalfactory.plotirrigationservice.transformer.PlotIrrigationSlotTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PlotIrrigationSlotServiceImpl implements PlotIrrigationSlotService{

    private final PlotIrrigationSlotTransformer plotIrrigationSlotTransformer;
    private final PlotIrrigationSlotDao plotIrrigationSlotDao;
    private final MessageService messageService;


    @Override
    public PlotIrrigationSlot doBeforeCreateEntity(PlotIrrigationSlot entity, PlotIrrigationSlotDTO dto) {
        return PlotIrrigationSlotService.super.doBeforeCreateEntity(entity, dto);
    }

    @Override
    public PlotIrrigationSlotTransformer getTransformer() {
        return plotIrrigationSlotTransformer;
    }

    @Override
    public PlotIrrigationSlotDao getDao() {
        return plotIrrigationSlotDao;
    }

    @Override
    public MessageService getMessageService() {
        return messageService;
    }
}
