package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static String convert(String number) {
        String newNotation = "";
        String oldNotation = number.replace(" ", ""); // remove spaces throughout
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < oldNotation.length(); i++) {

            if(Character.isDigit(oldNotation.charAt(i))) {
                newNotation += oldNotation.charAt(i);
            } else {
                newNotation += " ";
            }

            if(oldNotation.charAt(i) == '/' || oldNotation.charAt(i) == '*' ||
                    oldNotation.charAt(i) == 'x') {

                if (stack.empty()) {
                    Character acter = new Character(oldNotation.charAt(i)); // push symbol to stack
                    stack.push(acter);
                } else if (stack.peek().charValue() == '/' ||
                        stack.peek().charValue() == '*' ||
                        stack.peek().charValue() == 'x') {
                    newNotation += stack.pop().charValue();
                } else {

                    Character acter = new Character(oldNotation.charAt(i)); // push symbol to stack
                    stack.push(acter);
                }


            }

            if(oldNotation.charAt(i) == '+' || oldNotation.charAt(i) == '-') {
                if(stack.empty()) {
                    Character acter = new Character(oldNotation.charAt(i)); // push symbol to stack
                    stack.push(acter);
                } else if(stack.peek().charValue() == '(') {
                    Character acter = new Character(oldNotation.charAt(i)); // push symbol to stack
                    stack.push(acter);
                } else {
                    newNotation += oldNotation.charAt(i);
                }
            }

            if(oldNotation.charAt(i) == '(') {
                Character acter = new Character(oldNotation.charAt(i)); // push symbol to stack
                stack.push(acter);
            }

            if(oldNotation.charAt(i) == ')') {
                while(!(stack.peek().charValue() == '(')) {
                    newNotation += stack.pop().charValue();
                }

                stack.pop();
            }
        }

        while(!stack.empty()) {                 // empty stack at the end
            newNotation += " " + stack.pop().charValue();
        }

        return newNotation;
    }
}
