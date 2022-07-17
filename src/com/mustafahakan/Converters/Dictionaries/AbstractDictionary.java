package com.mustafahakan.Converters.Dictionaries;

import java.util.Map;

public abstract class AbstractDictionary {
    protected Map<String, String> ties;
    protected Map<String, String> digits;
    protected Map<String, String> decimals;

    public AbstractDictionary() {
        initDictionary();
    }

    protected abstract void initDictionary();

    public Map<String, String> getDecimals() {
        return decimals;
    }

    public Map<String, String> getTies() {
        return ties;
    }

    public Map<String, String> getDigits() {
        return digits;
    }
}
