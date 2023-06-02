package com.digitalfactory.baseservice.localization;

import com.digitalfactory.baseservice.model.LanguageEnum;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class LocaleUtil {
    public static LanguageEnum getLang() {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            return LanguageEnum.valueOf(locale.getLanguage().toUpperCase());
        }catch (Exception ex){
            //no language found with this locale
        }
        //default lang to return
        return LanguageEnum.EN;

    }

    public static Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public static LanguageEnum getLang(Locale locale) {
        return LanguageEnum.valueOf(locale.getLanguage().toUpperCase());
    }

    public static Locale getLocale(LanguageEnum lang) {
        return new Locale(lang.getValue().toLowerCase());
    }
}
