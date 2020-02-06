package com.example.roylmobile.language;

import java.util.Locale;

public enum  Languages {
    ARABIC("ar"), ENGLISH("en");
    private final String languageCode;
    private final String languageTitle;

    Languages(String code) {
        this.languageCode = code;
        Locale locale = new Locale(code);
        languageTitle = locale.getDisplayLanguage(locale);
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getLanguageTitle() {
        return languageTitle;
    }


}
