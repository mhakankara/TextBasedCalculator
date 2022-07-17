package com.mustafahakan.Operations;

import com.mustafahakan.Converters.ConverterFactory;
import com.mustafahakan.Converters.BaseIntegerToWordConverter;
import com.mustafahakan.Converters.BaseWordToIntegerConverter;

public abstract class Operation {

    // Properties
    private BaseWordToIntegerConverter wordToIntegerConverter;
    private BaseIntegerToWordConverter integerToWordConverter;
    private Language language = Language.TURKISH;

    // Constructor
    public Operation() {
        ConverterFactory converterFactory = new ConverterFactory();
        wordToIntegerConverter = converterFactory.createWordToIntegerConverter(language);
        integerToWordConverter = converterFactory.createIntegerToWordConverter(language);
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
