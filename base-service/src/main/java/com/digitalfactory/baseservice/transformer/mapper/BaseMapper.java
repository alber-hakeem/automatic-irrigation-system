package com.digitalfactory.baseservice.transformer.mapper;

import com.digitalfactory.baseservice.dto.BaseDto;
import com.digitalfactory.baseservice.model.BaseEntity;
import org.mapstruct.MappingTarget;


public interface BaseMapper<Entity extends BaseEntity, Dto extends BaseDto> {
    Entity dtoToEntity(Dto dto);
    Dto entityToDto(Entity entity);
    void updateEntity(Dto dto, @MappingTarget Entity entity);
}
