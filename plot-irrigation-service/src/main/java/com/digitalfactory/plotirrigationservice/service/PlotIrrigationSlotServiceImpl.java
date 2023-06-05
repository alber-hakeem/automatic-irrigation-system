package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDTO;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import com.digitalfactory.plotirrigationservice.transformer.PlotIrrigationSlotTransformer;
import com.digitalfactory.plotirrigationservice.validator.PlotIrrigationSlotValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;

@Service
@AllArgsConstructor
public class PlotIrrigationSlotServiceImpl implements PlotIrrigationSlotService{

    private final PlotIrrigationSlotTransformer plotIrrigationSlotTransformer;
    private final PlotIrrigationSlotDao plotIrrigationSlotDao;
    private final PlotCropService plotCropService;
    private final PlotIrrigationSlotValidator plotIrrigationSlotValidator;
    private final MessageService messageService;


    @Override
    public PlotIrrigationSlot doBeforeCreateEntity(PlotIrrigationSlot entity, PlotIrrigationSlotDTO dto) {
        entity.setPlotCrop(plotCropService.findEntityById(dto.getPlotCropId()).get());
        entity.setIrrigationStatus(IrrigationStatus.PENDING);
        if (plotIrrigationSlotValidator.isExists(dto)) {
            throw new EntityExistsException("Plot Irrigation slot already assigned at this time.");
        }
        return entity;
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
