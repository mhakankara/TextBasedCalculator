package com.mustafahakan.Operations;

import com.mustafahakan.Converters.WordToIntegerConverter;
import com.mustafahakan.Converters.ConverterFactory;
import com.mustafahakan.Converters.IntegerToWordConverter;
import com.mustafahakan.Language;
import com.mustafahakan.LanguageSettings;

public abstract class Operation {

    private ConverterFactory converterFactory = new ConverterFactory();

    private WordToIntegerConverter wordToIntegerConverter;
    private IntegerToWordConverter integerToWordConverter;

    public Operation() {
        wordToIntegerConverter =
                converterFactory.createWordToIntegerConverter(LanguageSettings.selectedLanguage);

        integerToWordConverter =
                converterFactory.createIntegerToWordConverter(LanguageSettings.selectedLanguage);
    }

    public Operation(Language src, Language dest) {
        wordToIntegerConverter = converterFactory.createWordToIntegerConverter(src);
        integerToWordConverter = converterFactory.createIntegerToWordConverter(dest);
    }

    // Methods
    protected abstract int operate(int[] operands);

    public abstract String getName();

    public String operate(String[] operands) {
        int[] int_operands = new int[operands.length];

        for (int i = 0; i < operands.length; i++) {
            int_operands[i] = wordToIntegerConverter.wordsToNumbers(operands[i]);
            System.out.println("Operand " + i + ": " + int_operands[i]);
        }

        int result = operate(int_operands);

        System.out.println("Integer Result: " + result);
        return integerToWordConverter.numberToWords(result);
    }
}
