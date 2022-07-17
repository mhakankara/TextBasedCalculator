package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.AbstractDictionary;

import java.util.Map;

public abstract class BaseConverter {

    // Properties
    protected AbstractDictionary dictionary;
    protected Map<String, String> units;
    protected Map<String, String> tys;
    protected Map<String, String> decimals;

    // Constructor
    public BaseConverter(AbstractDictionary dictionary) {
        this.dictionary = dictionary;
        initMaps();
    }

    // Method
    protected abstract void initMaps();

}
