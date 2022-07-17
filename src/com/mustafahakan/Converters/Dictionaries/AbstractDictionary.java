package com.mustafahakan.Converters.Dictionaries;

import java.util.Locale;
import java.util.Map;

public abstract class AbstractDictionary {
    protected Map<String, String> tys;
    protected Map<String, String> units;
    protected Map<String, String> decimals;

    public AbstractDictionary() {
        initDictionary();
    }

    protected abstract void initDictionary();
    public abstract Locale getLocale();

    public Map<String, String> getDecimals() {
        return decimals;
    }

    public Map<String, String> getTys() {
        return tys;
    }

    public Map<String, String> getUnits() {
        return units;
    }
}
