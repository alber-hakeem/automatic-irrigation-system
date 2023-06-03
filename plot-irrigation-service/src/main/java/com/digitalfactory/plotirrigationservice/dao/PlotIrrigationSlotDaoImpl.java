package com.digitalfactory.plotirrigationservice.dao;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.plotirrigationservice.dao.repo.PlotIrrigationSlotRepo;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@AllArgsConstructor
public class PlotIrrigationSlotDaoImpl implements PlotIrrigationSlotDao{

    private final PlotIrrigationSlotRepo plotIrrigationSlotRepo;
    @Override
    public PlotIrrigationSlotRepo getRepository() {
        return plotIrrigationSlotRepo;
    }
    @Override
    public List<PlotIrrigationSlot> findActiveIrrigationSlots() {
        return plotIrrigationSlotRepo.findSlotsByDateAndTimeAndStatus(LocalTime.now(), LocalDate.now(), IrrigationStatus.PENDING);
    }
}