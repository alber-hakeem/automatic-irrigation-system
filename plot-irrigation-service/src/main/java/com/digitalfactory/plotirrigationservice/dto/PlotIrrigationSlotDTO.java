package com.digitalfactory.plotirrigationservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;


@Data
public class PlotIrrigationSlotDTO {
    private LocalDateTime irrigationDate;
    private LocalTime irrigationStartTime;
    private LocalTime irrigationEndTime;
    private BigDecimal amountOfWater;
    private IrrigationStatus irrigationStatus;
}
