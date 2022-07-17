package com.mustafahakan.Operations;

public class Subtraction extends Operation {
    @Override
    protected int operate(int[] operands) {

        if (operands.length != 2) {
            throw new IllegalArgumentException("Number of operands must be exactly 2!");
        }

        int result = operands[0] - operands[1];
        return Math.max(result, 0);
    }

    @Override
    public String getName() {
        return "Subtract";
    }
}
