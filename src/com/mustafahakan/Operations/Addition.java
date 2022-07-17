package com.mustafahakan.Operations;

public class Addition extends Operation {
    @Override
    protected int operate(int[] operands) {
        int sum = 0;

        for (int argument : operands) {
            sum += argument;
        }

        return sum;
    }

    @Override
    public String getName() {
        return "Add";
    }
}
