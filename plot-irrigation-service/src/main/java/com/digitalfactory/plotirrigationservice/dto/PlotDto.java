package com.digitalfactory.plotirrigationservice.dto;

import com.digitalfactory.baseservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlotDto extends BaseDto {

    private Long id;
    @NotNull(message = "This field is required")
    private String name;

    @NotNull(message = "This field is required")
    @DecimalMin(value = "1", message = "minimum area is 1")
    private BigDecimal area;
    private String description;

}
