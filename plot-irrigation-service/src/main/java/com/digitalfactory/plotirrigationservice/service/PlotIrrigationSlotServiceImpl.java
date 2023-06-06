package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import com.digitalfactory.plotirrigationservice.transformer.PlotIrrigationSlotTransformer;
import com.digitalfactory.plotirrigationservice.validator.PlotIrrigationSlotValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class PlotIrrigationSlotServiceImpl implements PlotIrrigationSlotService{

    private final PlotIrrigationSlotTransformer plotIrrigationSlotTransformer;
    private final PlotIrrigationSlotDao plotIrrigationSlotDao;
    private final PlotCropService plotCropService;
    private final PlotIrrigationSlotValidator plotIrrigationSlotValidator;
    private final MessageService messageService;


    @Override
    public PlotIrrigationSlot doBeforeCreateEntity(PlotIrrigationSlot entity, PlotIrrigationSlotDto dto) {
        entity.setPlotCrop(plotCropService.findEntityById(dto.getPlotCropId()).get());
        entity.setIrrigationStatus(IrrigationStatus.PENDING);
        if (plotIrrigationSlotValidator.isExists(dto)) {
            throw new EntityExistsException("Plot Irrigation slot already assigned at this time.");
        }
        return entity;
    }

    @Override
    @Transactional
    public List<PlotIrrigationSlotDto> updateIrrigationSlots(Long plotCropId, Set<PlotIrrigationSlotDto> plotIrrigationSlotDTOS) {
        log.info("PlotSlotService updatePlotSlots(Long,Set<PlotSlotDto>)");
        PlotCropDto plotCropDto = plotCropService.findById(plotCropId);
        plotIrrigationSlotDTOS.forEach(plotIrrigationSlotDTO -> {
            plotIrrigationSlotDTO.setPlotCropId(plotCropDto.getId());
            if (plotCropDto.getPlotIrrigationSlots().contains(plotIrrigationSlotDTO))
                update(plotIrrigationSlotDTO, plotIrrigationSlotDTO.getId());
            else create(plotIrrigationSlotDTO);
        });
        plotCropDto.getPlotIrrigationSlots().stream().filter(dto -> !plotIrrigationSlotDTOS.contains(dto)).forEach(this::removeSlot);
        return new ArrayList<>(plotIrrigationSlotDTOS);
    }



    private void removeSlot(PlotIrrigationSlotDto plotIrrigationSlotDTO) {
        plotIrrigationSlotDTO.setMarkedAsDeleted(true);
        update(plotIrrigationSlotDTO, plotIrrigationSlotDTO.getId());
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
