package com.mustafahakan;

public class LanguageSettings {
    public static Language selectedLanguage = Language.TURKISH;
    public static void setLanguage(Language newLanguage) {
        selectedLanguage = newLanguage;
    }
}
