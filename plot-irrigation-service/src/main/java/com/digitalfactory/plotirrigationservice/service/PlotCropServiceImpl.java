package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotCropDao;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import com.digitalfactory.plotirrigationservice.transformer.PlotCropTransformer;
import com.digitalfactory.plotirrigationservice.validator.PlotCropValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.HashSet;

@Service
@AllArgsConstructor
@Slf4j
public class PlotCropServiceImpl implements PlotCropService{

    private final PlotCropTransformer plotCropTransformer;
    private final PlotCropDao plotCropDao;
    private final MessageService messageService;
    private final CropService cropService;
    private final PlotService plotService;
    private final PlotCropValidator plotCropValidator;
    private final PlotIrrigationSlotService plotIrrigationSlotService;

    @Override
    public PlotCrop doBeforeCreateEntity(PlotCrop plotCrop, PlotCropDto plotCropDto) {
        log.info("PlotCropService: doBeforeCreateEntity was called");

        if (plotCropValidator.isExists(plotCropDto)) {
            throw new EntityExistsException("Plot Crop already assigned at this period.");
        }
        plotCrop.setCrop(cropService.findEntityById(plotCropDto.getCropId()).get());
        plotCrop.setPlot(plotService.findEntityById(plotCropDto.getPlotId()).get());
        plotCrop.getPlotIrrigationSlots().forEach(plotIrrigationSlot -> {
            plotIrrigationSlot.setPlotCrop(plotCrop);
            plotIrrigationSlot.setIrrigationStatus(IrrigationStatus.PENDING);
        });
        return plotCrop;
    }

    @Override
    public PlotCrop doBeforeUpdateEntity(PlotCrop entity, PlotCropDto dto) {
        dto.setPlotId(entity.getPlotId());
        dto.setCropId(entity.getCropId());
        if (plotCropValidator.isExistsExcludeId(dto)) {
            throw new EntityExistsException("Plot Crop already assigned at this period.");
        }
        return entity;
    }

    @Override
    public PlotCropDto update(PlotCropDto dto, Long id) {
        PlotCrop savedDEntity = doUpdate(dto, id);
        PlotCropDto plotCropDto = getTransformer().transformEntityToDTO(savedDEntity);
        HashSet<PlotIrrigationSlotDto> plotIrrigationSlotDtos = new HashSet<>();
        if (!dto.getPlotIrrigationSlots().isEmpty()) plotIrrigationSlotDtos.addAll(dto.getPlotIrrigationSlots());
        plotCropDto.setPlotIrrigationSlots(plotIrrigationSlotService.updateIrrigationSlots(id, plotIrrigationSlotDtos));
        return plotCropDto;
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
