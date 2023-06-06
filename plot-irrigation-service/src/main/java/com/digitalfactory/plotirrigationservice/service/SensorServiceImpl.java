package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.plotirrigationservice.dao.PlotIrrigationSlotDao;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SensorServiceImpl implements SensorService {

    @Value("${retry.max.attempts}")
    private int retryMaxAttempts;

    @Value("${retry.delay.ms}")
    private int retryDelayMs;

    private final PlotIrrigationSlotDao plotIrrigationSlotDao;
    private final NotificationService notificationService;

    public SensorServiceImpl(PlotIrrigationSlotDao plotIrrigationSlotDao, NotificationService notificationService) {
        this.plotIrrigationSlotDao = plotIrrigationSlotDao;
        this.notificationService = notificationService;
    }



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



    /**
     * sendRequestToSensorDevice
     *
     * Integration code to send the irrigation request to the sensor device.
     * Return true if the request is successful, false otherwise.
     * If you want to simulate the failure situation change it to return false
     */

    private boolean sendRequestToSensorDevice(PlotIrrigationSlot plotIrrigationSlot) {
        log.info("SensorService: sendRequestToSensorDevice was called");
        return true;
    }

    private void retrySendingRequest(PlotIrrigationSlot plotIrrigationSlot) {
        log.info("SensorService: retrySendingRequest was called ");
        int retryCount = 0;
        boolean requestSuccessful = false;

        while (!requestSuccessful && retryCount < retryMaxAttempts) {
            try {
                Thread.sleep(retryDelayMs);
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

