package com.digitalfactory.plotirrigationservice.dto;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class PlotIrrigationSlotDTO {
    private LocalDate irrigationDate;
    private LocalTime irrigationStartTime;
    private LocalTime irrigationEndTime;
    private BigDecimal amountOfWater;
    private IrrigationStatus irrigationStatus;
}
