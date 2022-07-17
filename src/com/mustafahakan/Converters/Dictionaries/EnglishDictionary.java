package com.mustafahakan.Converters.Dictionaries;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.mustafahakan.Converters.Dictionaries.Utils.strToMap;

public class EnglishDictionary extends AbstractDictionary {

    public EnglishDictionary() {
        super();
    }

    @Override
    protected void initDictionary() {
        Map<String, String> irregulars =
                Utils.strToMap("{0: 'Ten', 1: 'Eleven', 2: 'Twelve', 4: 'Fourteen'}");
        Map<String, String> prefixes =
                Utils.strToMap("{2: 'Twen', 3: 'Thir', 4: 'For', 5: 'Fif', 8: 'Eigh'}");

        units = Utils.strToMap("{1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', " +
                "5: 'Five', 6: 'Six', 7: 'Seven', 8: 'Eight', 9: 'Nine'}");

        decimals = strToMap("{2: 'Hundred', 3: 'Thousand', 6: 'Million', 9: 'Billion'}");

        tys = new HashMap<>();

        // Generate teens and tys
        for (int digit = 0; digit < Utils.NUM_DIGITS; digit++) {
            String str_digit = Integer.toString(digit);
            String teen = Integer.toString(10 + digit);
            if (irregulars.containsKey(str_digit)) {
                units.put(teen, irregulars.get(str_digit));
            } else if (prefixes.containsKey(str_digit)) {
                units.put(teen, prefixes.get(str_digit) + "teen");
            } else {
                units.put(teen, units.get(str_digit) + "teen");
            }
        }

        for (int digit = 2; digit < Utils.NUM_DIGITS; digit++) {
            String str_digit = Integer.toString(digit);
            if (prefixes.containsKey(str_digit)) {
                tys.put(str_digit, prefixes.get(str_digit) + "ty");
            } else {
                tys.put(str_digit, units.get(str_digit) + "ty");
            }
        }
    }

    @Override
    public Locale getLocale() {
        return new Locale("en", "US");
    }
}

