package com.digitalfactory.plotirrigationservice.dto;

import com.digitalfactory.baseservice.dto.BaseDto;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class PlotCropDTO extends BaseDto {
    private Long plotId;
    private Long cropId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal cultivatedArea;
    private List<PlotIrrigationSlotDTO> plotIrrigationSlots;
}
