package com.ekinokssoftware.Converters;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseConverter {

    protected static final int NUM_DIGITS = 10;

    // Properties
    protected Map<String, String> irregulars;
    protected Map<String, String> prefixes;
    protected Map<String, String> digits;
    protected Map<String, String> decimals;
    protected Map<String, String> teens;
    protected Map<String, String> ties;

    // Constructor
    public BaseConverter() {
        initDictionaries();
    }

    // Methods
    protected final void initCoreDictionaries() {
        irregulars = strToMap("{0: 'Ten', 1: 'Eleven', 2: 'Twelve', 4: 'Fourteen'}");
        digits = strToMap("{1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', " +
                "5: 'Five', 6: 'Six', 7: 'Seven', 8: 'Eight', 9: 'Nine'}");
        prefixes = strToMap("{2: 'Twen', 3: 'Thir', 4: 'For', 5: 'Fif', 8: 'Eigh'}");
        teens = new HashMap<>();
        ties = new HashMap<>();

        // Generate teens and ties
        for (int digit = 0; digit < NUM_DIGITS; digit++) {
            String str_digit = Integer.toString(digit);
            if (irregulars.containsKey(str_digit)) {
                teens.put(str_digit, irregulars.get(str_digit));
            } else if (prefixes.containsKey(str_digit)) {
                teens.put(str_digit, prefixes.get(str_digit) + "teen");
            } else {
                teens.put(str_digit, digits.get(str_digit) + "teen");
            }
        }

        for (int digit = 2; digit < NUM_DIGITS; digit++) {
            String str_digit = Integer.toString(digit);
            if (prefixes.containsKey(str_digit)) {
                ties.put(str_digit, prefixes.get(str_digit) + "ty");
            } else {
                ties.put(str_digit, digits.get(str_digit) + "ty");
            }
        }
    }

    protected void initDictionaries() {
        initCoreDictionaries();
        decimals = strToMap("{2: 'Hundred', 3: 'Thousand', 6: 'Million', 9: 'Billion'}");
    }

    /*
        Allowed format: {key1: value1, key2: value2, ...}
    */
    protected final Map<String, String> strToMap(String str_map) {

        Map<String, String> map = new HashMap<>();
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        boolean started = false;

        for (int i = 0; i < str_map.length(); i++) {
            char c = str_map.charAt(i);

            if (c == '{' || c == ' ' || c == '\'' || c == '\"') {
                continue;
            }
            if (c == ',' || c == '}') {
                map.put(key.toString(), value.toString());
                key.setLength(0);
                value.setLength(0);
                started = false;
            } else if (started) {
                value.append(c);
            } else if (c == ':') {
                started = true;
            } else {
                key.append(c);
            }

        }

        return map;
    }
}
