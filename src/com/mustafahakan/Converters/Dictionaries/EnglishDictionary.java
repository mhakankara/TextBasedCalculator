package com.mustafahakan.Converters.Dictionaries;

import java.util.HashMap;
import java.util.Map;

import static com.mustafahakan.Converters.Dictionaries.Utils.strToMap;

public class EnglishDictionary extends AbstractDictionary {

    private Map<String, String> teens;

    public EnglishDictionary() {
        super();
    }

    @Override
    protected void initDictionary() {
        Map<String, String> irregulars =
                Utils.strToMap("{0: 'Ten', 1: 'Eleven', 2: 'Twelve', 4: 'Fourteen'}");
        Map<String, String> prefixes =
                Utils.strToMap("{2: 'Twen', 3: 'Thir', 4: 'For', 5: 'Fif', 8: 'Eigh'}");

        digits = Utils.strToMap("{1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', " +
                "5: 'Five', 6: 'Six', 7: 'Seven', 8: 'Eight', 9: 'Nine'}");

        decimals = strToMap("{2: 'Hundred', 3: 'Thousand', 6: 'Million', 9: 'Billion'}");

        teens = new HashMap<>();
        ties = new HashMap<>();

        // Generate teens and ties
        for (int digit = 0; digit < Utils.NUM_DIGITS; digit++) {
            String str_digit = Integer.toString(digit);
            if (irregulars.containsKey(str_digit)) {
                teens.put(str_digit, irregulars.get(str_digit));
            } else if (prefixes.containsKey(str_digit)) {
                teens.put(str_digit, prefixes.get(str_digit) + "teen");
            } else {
                teens.put(str_digit, digits.get(str_digit) + "teen");
            }
        }

        for (int digit = 2; digit < Utils.NUM_DIGITS; digit++) {
            String str_digit = Integer.toString(digit);
            if (prefixes.containsKey(str_digit)) {
                ties.put(str_digit, prefixes.get(str_digit) + "ty");
            } else {
                ties.put(str_digit, digits.get(str_digit) + "ty");
            }
        }
    }


    public Map<String, String> getTeens() {
        return teens;
    }
}

