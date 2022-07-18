package com.mustafahakan.Converters;

import com.mustafahakan.Converters.Dictionaries.AbstractDictionary;

import java.util.LinkedList;
import java.util.List;

public class IntegerToWordConverter extends BaseConverter {

    // Constructor
    public IntegerToWordConverter(AbstractDictionary dictionary) {
        super(dictionary);
    }

    @Override
    protected void initMaps() {
        if(dictionary != null) {
            decimals = dictionary.getDecimals();
            tys = dictionary.getTys();
            units = dictionary.getUnits();
        }
    }

    // Methods
    public String numberToWords(int num) {
        // Parse the input integer
        char[] str_num = Integer.toString(num).toCharArray();

        List<String> parsed = new LinkedList<>();

        parseNumber(str_num, 0, str_num.length, parsed);

        StringBuilder parsed_str = new StringBuilder();

        if (parsed.size() == 0) {
            return dictionary.getZero();
        }

        for (int i = 0; i < parsed.size() - 1; i++) {
            parsed_str.append(parsed.get(i)).append(" ");
        }

        parsed_str.append(parsed.get(parsed.size() - 1));

        return parsed_str.toString();
    }

    private void parseNumber(char[] str_num, int start, int end, List<String> parsed) {
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
            parsed.add(units.get(first));
        } else if (N == 2) {
            String firstTwo = first + str_num[start + 1];
            if (units.containsKey(firstTwo)) {
                parsed.add(units.get(firstTwo));
            } else {
                parsed.add(tys.get(first));
                parseNumber(str_num, start + 1, end, parsed);
            }
        } else if (decimals.containsKey(Integer.toString(N - 1))) {
            parsed.add(units.get(first));
            parsed.add(decimals.get(Integer.toString(N - 1)));
            parseNumber(str_num, start + 1, end, parsed);
        } else {
            parseNumber(str_num, start, start + remaining, parsed);
            parsed.add(decimals.get(String.valueOf(power)));
            parseNumber(str_num, start + remaining, end, parsed);
        }

    }

    private final int findPower(int numDigits) {
        return 3 * ((numDigits - 4) / 3 + 1);
    }
}
