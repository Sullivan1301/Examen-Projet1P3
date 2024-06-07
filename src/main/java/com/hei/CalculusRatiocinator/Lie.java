package com.hei.CalculusRatiocinator;

public class Lie implements Affirmation{
    private final String description;

    public Lie(String description) {
        this.description = description;
    }

    @Override
    public Boolean eval() {
        return false;
    }

    @Override
    public String getDescrption() {
        return description;
    }
}
