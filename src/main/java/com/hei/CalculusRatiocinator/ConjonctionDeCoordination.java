package com.hei.CalculusRatiocinator;

public abstract class ConjonctionDeCoordination implements Affirmation {
    protected final Affirmation left;
    protected final Affirmation right;

    protected ConjonctionDeCoordination(Affirmation left, Affirmation right) {
        this.left = left;
        this.right = right;
    }
}
