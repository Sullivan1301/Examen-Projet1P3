package com.hei.CalculusRatiocinator;

public class Truth implements Affirmation {
    private final String description;

    public Truth(String description) {
        this.description = description;
    }

    @Override
    public Boolean eval() {
        return true;
    }

    @Override
    public String getDescrption() {
        return description;
    }

}
