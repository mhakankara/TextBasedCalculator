package com.mustafahakan.Converters.Dictionaries;

import java.util.Locale;

import static com.mustafahakan.Converters.Dictionaries.Utils.strToMap;

public class TurkishDictionary extends AbstractDictionary {
    public TurkishDictionary() {
        super();
    }

    @Override
    protected void initDictionary() {
        zero = "Sıfır";

        units = strToMap("{1: 'Bir', 2: 'İki', 3: 'Üç', 4: 'Dört', " +
                "5: 'Beş', 6: 'Altı', 7: 'Yedi', 8: 'Sekiz', 9: 'Dokuz'}");

        tys = strToMap("{1: 'On', 2: 'Yirmi', 3: 'Otuz', 4: 'Kırk', " +
                "5: 'Elli', 6: 'Altmış', 7: 'Yetmiş', 8: Seksen', 9: 'Doksan'}");

        decimals = strToMap("{2: 'Yüz', 3: 'Bin', 6: 'Milyon', 9: 'Milyar'}");
    }

    @Override
    public Locale getLocale() {
        return new Locale("tr", "TR");
    }
}
