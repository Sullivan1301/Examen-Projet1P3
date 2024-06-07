package com.hei.CalculusRatiocinator;

public class Et extends ConjonctionDeCoordination {
    public Et(Affirmation left, Affirmation right) {
        super(left, right);
    }

    @Override
    public Boolean eval(){
        return left.eval() && right.eval();
    }

    @Override
    public String getDescrption() {
        return left.getDescrption() + " et " +right.getDescrption();
    }
}
