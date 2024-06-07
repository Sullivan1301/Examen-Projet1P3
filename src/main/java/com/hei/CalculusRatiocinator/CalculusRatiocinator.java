package com.hei.CalculusRatiocinator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalculusRatiocinator {
    public static final Map<String, Affirmation> affirmationsMap = new HashMap<String, Affirmation>(){
        static {
            affirmationsMap.put("verite_1", new Truth("Lou est beau"));
            affirmationsMap.put("mensonge_1", new Lie("Lou est pauvre"));
            affirmationsMap.put("affirmation_1_vraie", new SimpleAffirmation(true, "Lou est genereux"));
            affirmationsMap.put("affirmation_2_fausse", new SimpleAffirmation(false, "Lou est genereux"));
        }



        public static Boolean eval(String expression){
            String[] tokens = expression.split(" ");
            Stack<Affirmation> stack = new Stack<>();

            for (String token : tokens){
                token.toLowerCase();
                switch (token){
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
                    default:
                        if (affirmationsMap.containsKey(token)){
                            stack.push(affirmationsMap.get(token));
                        } else {
                            throw  new IllegalArgumentException("Unknown" + token);
                        }
                        break;
                }
            }
            if (stack.size() !=1){
                throw new IllegalArgumentException("Invalid expression");
            }
            return stack.pop().eval();
        }
    };
}
