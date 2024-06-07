package com.hei.CalculusRatiocinator;

public class SimpleAffirmation implements Affirmation{
    private final Boolean value;

    public SimpleAffirmation(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean eval() {
        return null;
    }
}
