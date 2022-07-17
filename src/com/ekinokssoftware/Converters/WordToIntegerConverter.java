package com.ekinokssoftware.Converters;

import java.util.HashMap;
import java.util.Map;

public class WordToIntegerConverter extends BaseConverter {

    // Constructor
    public WordToIntegerConverter() {
        super();
    }

    // Methods
    @Override
    protected void initDictionaries() {
        initCoreDictionaries();

        decimals = strToMap("{'Hundred': '100', 'Thousand': '1000', " +
                "'Million': '1000000', 'Billion': '1000000000'}");

        // Generate teens and ties
        teens = reverseMap(teens);
        ties = reverseMap(ties);
        digits = reverseMap(digits);
    }

    public int wordsToNumbers(String word_num) {
        // Parse the input integer
        String[] word_arr = word_num.split(" ");

        return parseWord(word_arr, 0, word_arr.length);
    }

    private int parseWord(String[] word_arr, int start, int end) {

        int N = end - start;

        if (N <= 0) {
            return 0;
        }

        if (N > 1 && decimals.containsKey(word_arr[start + 1])) {
            int second = Integer.parseInt(decimals.get(word_arr[start + 1]));
            if(second == 100 && N > 2) {
                String third = word_arr[start + 2];
                if (decimals.containsKey(third)) {
                    int decimal = second * Integer.parseInt(decimals.get(third));
                    return parseWord(word_arr, start, start + 1) * decimal +
                            parseWord(word_arr, start + 3, end);
                }
            }

            return parseWord(word_arr, start, start + 1) * Integer.parseInt(decimals.get(second))
                    + parseWord(word_arr, start + 2, end);
        }

        String first = word_arr[start];

        if (ties.containsKey(first)) {
            return 10 * Integer.parseInt(ties.get(first)) + parseWord(word_arr, start + 1, end);
        }

        if (teens.containsKey(first)) {
            return 10 + Integer.parseInt(teens.get(first));
        }

        if (digits.containsKey(first)) {
            return Integer.parseInt(digits.get(first));
        }

        return -1;
    }

    private Map<String, String> reverseMap(Map<String, String> map) {
        Map<String, String> reversed = new HashMap<>();

        for (String key : map.keySet()) {
            String value = map.get(key);
            reversed.put(value, key);
        }

        return reversed;
    }
}
