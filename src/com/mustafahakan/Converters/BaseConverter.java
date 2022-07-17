package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.AbstractDictionary;

import java.util.Map;

public abstract class BaseConverter {

    protected AbstractDictionary dictionary;
    protected Map<String, String> ties;
    protected Map<String, String> digits;
    protected Map<String, String> decimals;

    // Constructor
    public BaseConverter() {
        initMaps();
    }

    // Method
    protected abstract void initMaps();

}
