package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.TurkishDictionary;

public class TurkishWordToIntegerConverter extends BaseWordToIntegerConverter {

    // Constructor
    public TurkishWordToIntegerConverter() {
        super();
    }

    // Methods
    @Override
    protected void initMaps() {
        dictionary = new TurkishDictionary();
        super.initMaps();
    }

}
