package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.EnglishDictionary;
import com.mustafahakan.Converters.Dictionaries.TurkishDictionary;
import com.mustafahakan.Language;

public class ConverterFactory {
    public WordToIntegerConverter createWordToIntegerConverter(Language language) {
        switch (language) {
            case ENGLISH:
                return new WordToIntegerConverter(new EnglishDictionary());
            default:
                return new WordToIntegerConverter(new TurkishDictionary());
        }
    }

    public IntegerToWordConverter createIntegerToWordConverter(Language language) {
        switch (language) {
            case ENGLISH:
                return new IntegerToWordConverter(new EnglishDictionary());
            default:
                return new IntegerToWordConverter(new TurkishDictionary());
        }
    }
}
