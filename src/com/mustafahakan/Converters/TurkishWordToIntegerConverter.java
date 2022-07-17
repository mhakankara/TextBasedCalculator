package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.TurkishDictionary;

import java.util.Locale;

public class TurkishWordToIntegerConverter extends BaseWordToIntegerConverter {

    // Constructor
    public TurkishWordToIntegerConverter() {
        super();
        this.locale = new Locale("tr", "TR");
    }

    // Method
    @Override
    protected void initMaps() {
        dictionary = new TurkishDictionary();
        super.initMaps();
    }

}
