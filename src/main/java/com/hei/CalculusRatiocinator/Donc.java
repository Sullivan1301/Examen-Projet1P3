package com.hei.CalculusRatiocinator;

public class Donc extends ConjonctionDeCoordination{
    public Donc (Affirmation left, Affirmation right){
        super(left, right);
    }

    @Override
    public Boolean eval(){
        return !left.eval() || right.eval();
    }
}
