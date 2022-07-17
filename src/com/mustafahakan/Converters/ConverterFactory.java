package com.mustafahakan.Converters;

import com.mustafahakan.Converters.*;
import com.mustafahakan.Operations.Language;

public class ConverterFactory {
    public BaseWordToIntegerConverter createWordToIntegerConverter(Language language) {
        switch (language) {
            case ENGLISH:
                return new EnglishWordToIntegerConverter();
            default:
                return new TurkishWordToIntegerConverter();
        }
    }

    public BaseIntegerToWordConverter createIntegerToWordConverter(Language language) {
        switch (language) {
            case ENGLISH:
                return new IntegerToEnglishWordConverter();
            default:
                return new IntegerToTurkishWordConverter();
        }
    }
}
