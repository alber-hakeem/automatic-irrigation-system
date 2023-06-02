package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotCropDao;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDTO;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import com.digitalfactory.plotirrigationservice.transformer.PlotCropTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlotCropServiceImpl implements PlotCropService{

    private final PlotCropTransformer plotCropTransformer;
    private final PlotCropDao plotCropDao;
    private final MessageService messageService;
    private final CropService cropService;
    private final PlotService plotService;

    @Override
    public PlotCrop doBeforeCreateEntity(PlotCrop plotCrop, PlotCropDTO plotCropDTO) {

        plotCrop.setCrop(cropService.findEntityById(plotCropDTO.getCropId()).get());
        plotCrop.setPlot(plotService.findEntityById(plotCropDTO.getPlotId()).get());
        plotCrop.getPlotIrrigationSlots().forEach(plotIrrigationSlot -> {
            plotIrrigationSlot.setPlotCrop(plotCrop);
            plotIrrigationSlot.setIrrigationStatus(IrrigationStatus.PENDING);
        });
        return plotCrop;
    }

    @Override
    public PlotCropTransformer getTransformer() {
        return plotCropTransformer;
    }

    @Override
    public PlotCropDao getDao() {
        return plotCropDao;
    }

    @Override
    public MessageService getMessageService() {
        return messageService;
    }
}
