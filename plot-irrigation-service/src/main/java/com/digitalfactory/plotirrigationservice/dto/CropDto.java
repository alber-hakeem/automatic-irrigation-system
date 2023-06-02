package com.digitalfactory.plotirrigationservice.dto;


import com.digitalfactory.baseservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDto extends BaseDto {
    private Long id;
    private String name;
    private String description;

}
