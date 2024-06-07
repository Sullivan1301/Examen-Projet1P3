package com.hei.CalculusRatiocinator;

public class SimpleAffirmation implements Affirmation{
    private final Boolean value;
    private final String description;

    public SimpleAffirmation(Boolean value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Boolean eval() {
        return null;
    }

    @Override
    public String getDescrption() {
        return "";
    }
}
