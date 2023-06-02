package com.digitalfactory.baseservice.service;

import com.digitalfactory.baseservice.dao.MessageDao;
import com.digitalfactory.baseservice.dto.MessageDto;
import com.digitalfactory.baseservice.model.LanguageEnum;
import com.digitalfactory.baseservice.model.Message;
import com.digitalfactory.baseservice.model.MessageTypeEnum;
import com.digitalfactory.baseservice.transformer.MessageTransformer;
import org.springframework.context.MessageSourceAware;

import java.util.List;
import java.util.Map;


public interface MessageService extends BaseService<Message, MessageDto, MessageTransformer, MessageDao>, MessageSourceAware {
    Message findByCodeAndLang(String code, LanguageEnum lang);
    String findMessageByCodeAndLang(String code, LanguageEnum lang);
    String findMessageByCodeAndLang(String code);
    Message findByModuleAndCodeAndLang(String module,String code, LanguageEnum lang);
    String findMessageByModuleAndCodeAndLang(String module,String code, LanguageEnum lang);
    String findMessageByModuleAndCodeAndLang(String module,String code);
    List<Message> findByModuleAndTypeAndLang(String module, MessageTypeEnum type, LanguageEnum lang);
    List<Message> findByModuleAndType(String module, MessageTypeEnum type);
    Map<String, Map<String, MessageDto>>findByModuleAndTypeGroupBy(String module, MessageTypeEnum type);
    List<Message> findResourceBundleMessages(LanguageEnum lang);
}
