package com.digitalfactory.baseservice.transformer.mapper;

import com.digitalfactory.baseservice.dto.MessageDto;
import com.digitalfactory.baseservice.model.Message;
import com.digitalfactory.baseservice.transformer.MessageTransformer;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = MessageTransformer.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = MapStructCentralConfig.class)
public interface MessageMapper extends BaseMapper<Message, MessageDto> {
}
