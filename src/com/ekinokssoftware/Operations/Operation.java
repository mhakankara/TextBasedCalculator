package com.ekinokssoftware.Operations;

import com.ekinokssoftware.Converters.IntegerToTurkishWordConverter;
import com.ekinokssoftware.Converters.IntegerToWordConverter;
import com.ekinokssoftware.Converters.TurkishWordToIntegerConverter;
import com.ekinokssoftware.Converters.WordToIntegerConverter;

public abstract class Operation {
    // Properties
    IntegerToWordConverter integerToWordConverter;
    WordToIntegerConverter wordToIntegerConverter;

    // Constructor
    public Operation() {
        integerToWordConverter = new IntegerToWordConverter();
        wordToIntegerConverter = new WordToIntegerConverter();
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
