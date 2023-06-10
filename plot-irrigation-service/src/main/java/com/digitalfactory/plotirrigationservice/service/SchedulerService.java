/**
 * Scheduler Service
 *
 * This service should be implemented as a standalone service and run as a multithreaded application.
 * It is responsible for scheduling and executing tasks at specific times or intervals.
 * The multithreaded nature allows for concurrent execution of scheduled tasks, improving performance
 * and responsiveness.
 */
package com.digitalfactory.plotirrigationservice.service;


import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
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
