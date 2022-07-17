package com.mustafahakan;

public class Locale {
    public static Language selectedLanguage = Language.TURKISH;

    public static void setLanguage(Language newLanguage) {
        selectedLanguage = newLanguage;
    }

    public static String getLanguage() {
        return selectedLanguage.toString();
    }
}
