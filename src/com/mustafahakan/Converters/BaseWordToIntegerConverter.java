package com.mustafahakan.Converters;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class BaseWordToIntegerConverter extends BaseConverter {

    // Constructor
    public BaseWordToIntegerConverter() {
        super();
    }

    // Methods
    @Override
    protected void initMaps() {
        if(dictionary != null) {
            decimals = reverseMap(dictionary.getDecimals());
            ties = reverseMap(dictionary.getTies());
            digits = reverseMap(dictionary.getDigits());
        }
    }

    public final int wordsToNumbers(String word_num) {
        // Parse the input integer
        String[] word_arr = word_num.split(" ");

        return parseWord(word_arr, 0, word_arr.length, 0, 0);
    }

    protected int parseWord(String[] word_arr, int start, int end, int current, int total) {

        int N = end - start;

        if (N <= 0) {
            return current + total;
        }

        String first = word_arr[start];
        int value = 0;

        if (decimals.containsKey(first)) {
            value = (int) Math.pow(10, parseInt(decimals.get(first)));

            if (current == 0) {
                current = 1;
            }

            if (current < 1000) {
                current *= value;
            }

            if (current >= 1000) {
                total += current;
                current = 0;
            }
        }

        else {
            if (ties.containsKey(first)) {
                value = 10 * parseInt(ties.get(first));
            }


            else if (digits.containsKey(first)) {
                value = parseInt(digits.get(first));
            }

            current += value;
        }

        return parseWord(word_arr, start + 1, end, current, total);
    }

    protected Map<String, String> reverseMap(Map<String, String> map) {
        Map<String, String> reversed = new HashMap<>();

        for (String key : map.keySet()) {
            String value = map.get(key);
            reversed.put(value, key);
        }

        return reversed;
    }

}
