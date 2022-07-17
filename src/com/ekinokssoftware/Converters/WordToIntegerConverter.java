package com.ekinokssoftware.Converters;

import static java.lang.Integer.parseInt;

public class WordToIntegerConverter extends BaseConverter {

    // Constructor
    public WordToIntegerConverter() {
        super();
    }

    // Methods
    @Override
    protected void initDictionaries() {
        initCoreDictionaries();

        decimals = Utils.strToMap("{'Hundred': '100', 'Thousand': '1000', " +
                "'Million': '1000000', 'Billion': '1000000000'}");

        // Generate teens and ties
        teens = Utils.reverseMap(teens);
        ties = Utils.reverseMap(ties);
        digits = Utils.reverseMap(digits);
    }

    public int wordsToNumbers(String word_num) {
        // Parse the input integer
        String[] word_arr = word_num.split(" ");

        return parseWord(word_arr, 0, word_arr.length, 0, 0);
    }

    private int parseWord(String[] word_arr, int start, int end, int current, int total) {

        int N = end - start;

        if (N <= 0) {
            return current + total;
        }

        String first = word_arr[start];
        int value = 0;

        if (decimals.containsKey(first)) {
            value = parseInt(decimals.get(first));

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
            if (teens.containsKey(first)) {
                value = 10 + parseInt(teens.get(first));

            }

            else if (ties.containsKey(first)) {
                value = 10 * parseInt(ties.get(first));
            }


            else if (digits.containsKey(first)) {
                value = parseInt(digits.get(first));
            }

            current += value;
        }

        return parseWord(word_arr, start + 1, end, current, total) ;
    }

}
