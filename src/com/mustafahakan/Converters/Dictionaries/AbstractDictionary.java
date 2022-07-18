package com.mustafahakan.Converters.Dictionaries;

import java.util.Locale;
import java.util.Map;

public abstract class AbstractDictionary {
    protected Map<String, String> tys;
    protected Map<String, String> units;
    protected Map<String, String> decimals;
    protected String zero;

    public AbstractDictionary() {
        initDictionary();
    }

    protected abstract void initDictionary();
    public abstract Locale getLocale();

    public String getZero() {
        return zero;
    }

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
