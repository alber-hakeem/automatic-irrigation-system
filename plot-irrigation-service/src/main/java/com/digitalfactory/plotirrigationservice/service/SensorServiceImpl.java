package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SensorServiceImpl implements SensorService {

    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final int RETRY_DELAY_MS = 2000;

    private final PlotIrrigationSlotDao plotIrrigationSlotDao;
    private final NotificationService notificationService;



    @Override
    public void sendIrrigationRequest(PlotIrrigationSlot plotIrrigationSlot) {
        log.info("SensorService: sendIrrigationRequest was called");
        boolean requestSuccessful = sendRequestToSensorDevice(plotIrrigationSlot);
        if (requestSuccessful) {
            log.info("SensorService: Irrigation Completed ");
            updateIrrigationStatus(plotIrrigationSlot,IrrigationStatus.COMPLETED);
        } else {
            log.info("SensorService: Irrigation Failed and retry called ");
            retrySendingRequest(plotIrrigationSlot);
        }
    }



    private boolean sendRequestToSensorDevice(PlotIrrigationSlot plotIrrigationSlot) {
        log.info("SensorService: sendRequestToSensorDevice was called");
        return true;
        // Integration code to send the irrigation request to the sensor device
        // Return true if the request is successful, false otherwise
    }

    private void retrySendingRequest(PlotIrrigationSlot plotIrrigationSlot) {
        log.info("SensorService: retrySendingRequest was called ");
        int retryCount = 0;
        boolean requestSuccessful = false;

        while (!requestSuccessful && retryCount < MAX_RETRY_ATTEMPTS) {
            try {
                Thread.sleep(RETRY_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            try {
                requestSuccessful=sendRequestToSensorDevice(plotIrrigationSlot);
            } catch (Exception e) {
                log.error("Exception in retrying " + e.getMessage());
            }
            retryCount++;
        }
        if (!requestSuccessful) {
            updateIrrigationStatus(plotIrrigationSlot,IrrigationStatus.FAILED);
            notificationService.sendNotification("Failed to send irrigation request for plot: " + plotIrrigationSlot.getPlotCrop().getPlot().getName());
        }
        else {
            updateIrrigationStatus(plotIrrigationSlot,IrrigationStatus.COMPLETED);
        }
    }

    private void updateIrrigationStatus(PlotIrrigationSlot plotIrrigationSlot,IrrigationStatus irrigationStatus) {
        plotIrrigationSlot.setIrrigationStatus(irrigationStatus);
        plotIrrigationSlotDao.update(plotIrrigationSlot);
    }
}

