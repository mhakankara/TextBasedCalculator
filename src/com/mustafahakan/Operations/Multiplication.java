package com.mustafahakan.Operations;

public class Multiplication extends Operation {
    @Override
    protected int operate(int[] operands) {
        int result = 1;

        for (int argument : operands) {
            result *= argument;
        }

        return result;
    }

    @Override
    public String getName() {
        return "Multiply";
    }
}
