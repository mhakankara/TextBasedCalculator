package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.TurkishDictionary;

public class IntegerToTurkishWordConverter extends BaseIntegerToWordConverter {

    // Constructor
    public IntegerToTurkishWordConverter() {
        super();
    }

    @Override
    protected void initMaps() {
        dictionary = new TurkishDictionary();
        super.initMaps();
    }
}
