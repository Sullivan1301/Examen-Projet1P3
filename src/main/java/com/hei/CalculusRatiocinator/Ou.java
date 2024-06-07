package com.hei.CalculusRatiocinator;

public class Ou extends ConjonctionDeCoordination {
    public Ou(Affirmation left, Affirmation right) {
        super(left, right);
    }
    @Override
    public Boolean eval(){
        return left.eval() || right.eval();
    }
}
