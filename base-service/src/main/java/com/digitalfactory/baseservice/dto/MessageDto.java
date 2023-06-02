package com.digitalfactory.baseservice.dto;

import com.digitalfactory.baseservice.model.LanguageEnum;
import com.digitalfactory.baseservice.model.MessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageDto extends BaseDto {
    private Long id;
    private String module;
    private String code;
    private String message;
    private LanguageEnum lang;
    private MessageTypeEnum type;
    private String iconUrl;
}
