package com.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("({[}])"));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] parenthesis = s.toCharArray();
        for (int i = 0; i < parenthesis.length; i++) {
            if (parenthesis[i] == '{' || parenthesis[i] == '[' || parenthesis[i] == '(') {
                stack.push(parenthesis[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char openParan = stack.pop();
                if ((parenthesis[i] == ')' && openParan != '(') ||
                        (parenthesis[i] == ']' && openParan != '[') ||
                        (parenthesis[i] == '}' && openParan != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
