package com.mustafahakan.Converters.Dictionaries;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    protected static final int NUM_DIGITS = 10;

    /*
        Allowed format: {key1: value1, key2: value2, ...}
    */
    public static Map<String, String> strToMap(String str_map) {

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
