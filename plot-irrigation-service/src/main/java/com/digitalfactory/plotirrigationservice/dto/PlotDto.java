package com.digitalfactory.plotirrigationservice.dto;

import com.digitalfactory.baseservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlotDto extends BaseDto {

    private Long id;
    private String name;
    private BigDecimal area;
    private String description;

}
