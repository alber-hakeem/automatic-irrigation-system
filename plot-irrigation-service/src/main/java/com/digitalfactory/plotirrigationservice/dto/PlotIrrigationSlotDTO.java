package com.digitalfactory.plotirrigationservice.dto;

import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.baseservice.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class PlotIrrigationSlotDTO extends BaseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long plotCropId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private PlotCropDTO plotCrop;

    @Future(message = "Irrigation date must be in the future")
    private LocalDate irrigationDate;

    @NotNull(message = "This field is required")
    private LocalTime irrigationStartTime;

    @NotNull(message = "This field is required")
    private LocalTime irrigationEndTime;

    @NotNull(message = "This field is required")
    @DecimalMin(value = "1", message = "minimum area is 1")
    private BigDecimal amountOfWater;

    private IrrigationStatus irrigationStatus;


    @AssertTrue(message = "Irrigation end time must be greater than start date")
    private boolean isEndTimeAfterStartTime() {
        return irrigationEndTime == null || irrigationEndTime.isAfter(irrigationStartTime);
    }


}
