package com.digitalfactory.baseservice.dao;

import com.digitalfactory.baseservice.dao.repo.MessageRepo;
import com.digitalfactory.baseservice.model.LanguageEnum;
import com.digitalfactory.baseservice.model.Message;
import com.digitalfactory.baseservice.model.MessageTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MessageDaoImpl implements MessageDao {
    private final MessageRepo messageRepo;

    public MessageDaoImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public MessageRepo getRepository() {
        return messageRepo;
    }

    @Override
    public Optional<Message> findByCodeAndLang(String code, LanguageEnum lang) {
        return messageRepo.findByCodeAndLang(code, lang);
    }

    @Override
    public Optional<Message> findByModuleAndCodeAndLang(String module, String code, LanguageEnum lang) {
        return messageRepo.findByModuleAndCodeAndLang(module, code, lang);
    }

    @Override
    public List<Message> findByModuleAndTypeAndLang(String module, MessageTypeEnum type, LanguageEnum lang) {
        return messageRepo.findByModuleAndTypeAndLang(module, type, lang);
    }

    @Override
    public List<Message> findByModuleAndType(String module, MessageTypeEnum type) {
        return messageRepo.findByModuleAndType(module, type);
    }
}
