package com.mustafahakan.Operations;

import com.mustafahakan.Converters.BaseWordToIntegerConverter;
import com.mustafahakan.Converters.ConverterFactory;
import com.mustafahakan.Converters.BaseIntegerToWordConverter;
import com.mustafahakan.Locale;

public abstract class Operation {

    private ConverterFactory converterFactory = new ConverterFactory();

    private BaseWordToIntegerConverter wordToIntegerConverter;
    private BaseIntegerToWordConverter integerToWordConverter;

    public Operation() {
        wordToIntegerConverter = converterFactory.createWordToIntegerConverter(Locale.selectedLanguage);
        integerToWordConverter = converterFactory.createIntegerToWordConverter(Locale.selectedLanguage);
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
