package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.EnglishDictionary;

import java.util.List;
import java.util.Map;

public class IntegerToEnglishWordConverter extends BaseIntegerToWordConverter {

    private Map<String, String> teens;

    // Constructor
    public IntegerToEnglishWordConverter() {
        super();
    }

    @Override
    protected void initMaps() {
        dictionary = new EnglishDictionary();
        super.initMaps();
        teens = ((EnglishDictionary) dictionary).getTeens();
    }

    // Method
    @Override
    protected void parseNumber(char[] str_num, int start, int end, List<String> parsed) {
        int N = end - start;

        if (N == 0) {
            return;
        }

        String first = String.valueOf(str_num[start]);
        int power = findPower(N);
        int remaining = N - power;

        if (first.equals("0")) {
            parseNumber(str_num, start + 1, end, parsed);
        } else if (N == 1) {
            parsed.add(digits.get(first));
        } else if (N == 2) {
            if (first.equals("1")) {
                String second = String.valueOf(str_num[start + 1]);
                parsed.add(teens.get(second));
            } else {
                parsed.add(ties.get(first));
                parseNumber(str_num, start + 1, end, parsed);
            }
        } else if (decimals.containsKey(Integer.toString(N - 1))) {
            parsed.add(digits.get(first));
            parsed.add(decimals.get(Integer.toString(N - 1)));
            parseNumber(str_num, start + 1, end, parsed);
        } else {
            parseNumber(str_num, start, start + remaining, parsed);
            parsed.add(decimals.get(String.valueOf(power)));
            parseNumber(str_num, start + remaining, end, parsed);
        }

    }
}
