package com.digitalfactory.plotirrigationservice.service;


import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dao.repo.PlotIrrigationSlotRepo;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component

public class SchedulerService {
    private final PlotIrrigationSlotDao plotIrrigationSlotDao;
    private final SensorService sensorService;

    @Scheduled(fixedRate = 5000)
    public void checkTimeSlotsForIrrigation() {
        log.info("SchedulerService: checkTimeSlotsForIrrigation was called");
        List<PlotIrrigationSlot> activeIrrigationSlots = plotIrrigationSlotDao.findActiveIrrigationSlots();
        if (!activeIrrigationSlots.isEmpty()) {
            activeIrrigationSlots.forEach(plotIrrigationSlot -> {
                plotIrrigationSlot.setIrrigationStatus(IrrigationStatus.IN_PROGRESS);
                plotIrrigationSlotDao.update(plotIrrigationSlot);
                sensorService.sendIrrigationRequest(plotIrrigationSlot);
            });
      }
    }
}
