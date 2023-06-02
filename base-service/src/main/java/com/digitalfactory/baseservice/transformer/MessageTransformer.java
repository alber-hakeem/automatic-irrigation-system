package com.digitalfactory.baseservice.transformer;

import com.digitalfactory.baseservice.dto.MessageDto;
import com.digitalfactory.baseservice.model.Message;
import com.digitalfactory.baseservice.transformer.mapper.MessageMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageTransformer implements BaseTransformer<Message, MessageDto, MessageMapper> {
    private final MessageMapper messageMapper;

    public MessageTransformer(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public MessageMapper getMapper() {
        return messageMapper;
    }
}
