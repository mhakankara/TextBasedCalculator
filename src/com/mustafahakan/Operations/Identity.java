package com.mustafahakan.Operations;

import com.mustafahakan.Language;

public class Identity extends Operation {

    public Identity(Language src, Language dest) {
        super(src, dest);
    }

    @Override
    protected int operate(int[] operands) {
        if (operands.length != 1) {
            throw new IllegalArgumentException("Number of operands must be exactly 1!");
        }

        return operands[0];
    }

    @Override
    public String getName() {
        return "Identity";
    }
}
