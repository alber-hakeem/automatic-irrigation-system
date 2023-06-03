package com.digitalfactory.plotirrigationservice.dto;

import com.digitalfactory.baseservice.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlotCropDTO extends BaseDto {

    @NotNull(message = "This field is required")
    private Long plotId;

    @NotNull(message = "This field is required")
    private Long cropId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private PlotDto plot;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CropDto crop;

    @Future(message = "Start date must be in the future")
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @AssertTrue(message = "End date must be greater than start date")
    private boolean isEndDateAfterStartDate() {
        return endDate == null || endDate.isAfter(startDate);
    }

    @NotNull(message = "This field is required")
    @DecimalMin(value = "1", message = "minimum area is 1")
    private BigDecimal cultivatedArea;

    private List<PlotIrrigationSlotDTO> plotIrrigationSlots;
}
