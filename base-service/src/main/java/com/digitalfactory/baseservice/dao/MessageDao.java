package com.digitalfactory.baseservice.dao;


import com.digitalfactory.baseservice.dao.repo.MessageRepo;
import com.digitalfactory.baseservice.model.LanguageEnum;
import com.digitalfactory.baseservice.model.Message;
import com.digitalfactory.baseservice.model.MessageTypeEnum;

import java.util.List;
import java.util.Optional;


public interface MessageDao extends BaseDao<Message, MessageRepo> {
    Optional<Message> findByCodeAndLang(String code, LanguageEnum lang);
    Optional<Message> findByModuleAndCodeAndLang(String module, String code, LanguageEnum lang);
    List<Message> findByModuleAndTypeAndLang(String module, MessageTypeEnum type, LanguageEnum lang);
    List<Message> findByModuleAndType(String module, MessageTypeEnum type);
}
