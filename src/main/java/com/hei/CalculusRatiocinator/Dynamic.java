package com.hei.CalculusRatiocinator;

import java.util.Stack;

public class Dynamic {
    public static Boolean eval(String expression) {
        // Tokenize the input expression
        String[] tokens = expression.split(" ");
        Stack<Affirmation> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "et":
                    Affirmation rightEt = stack.pop();
                    Affirmation leftEt = stack.pop();
                    stack.push(new Et(leftEt, rightEt));
                    break;
                case "ou":
                    Affirmation rightOu = stack.pop();
                    Affirmation leftOu = stack.pop();
                    stack.push(new Ou(leftOu, rightOu));
                    break;
                case "donc":
                    Affirmation rightDonc = stack.pop();
                    Affirmation leftDonc = stack.pop();
                    stack.push(new Donc(leftDonc, rightDonc));
                    break;
                case "vérité_1":
                    stack.push(new Truth());
                    break;
                case "mensonge_1":
                    stack.push(new Lie());
                    break;
                case "affirmation_1":
                    stack.push(new SimpleAffirmation(true)); // Assuming true for this example
                    break;
                case "affirmation_1_faux":
                    stack.push(new SimpleAffirmation(false)); // To test both true and false cases
                    break;
                default:
                    throw new IllegalArgumentException("Unknown token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid expression");
        }

        return stack.pop().eval();
    }
}
