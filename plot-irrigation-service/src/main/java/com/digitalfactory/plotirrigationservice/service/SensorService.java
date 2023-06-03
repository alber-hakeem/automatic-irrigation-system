package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;

public interface SensorService {
    void sendIrrigationRequest(PlotIrrigationSlot plotIrrigationSlot);

}
