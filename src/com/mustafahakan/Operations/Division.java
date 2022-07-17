package com.mustafahakan.Operations;

public class Division extends Operation {
    @Override
    protected int operate(int[] operands) {
        if(operands.length != 2) {
            throw new IllegalArgumentException("Number of operands must be exactly 2!");
        }

        return operands[0] / operands[1];
    }

    @Override
    public String getName() {
        return "Divide";
    }
}
