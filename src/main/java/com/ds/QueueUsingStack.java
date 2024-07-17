package com.ds;

import java.util.Stack;

public class QueueUsingStack {

    private static Stack inputStack;
    private static Stack outputStack;

    public QueueUsingStack() {
        inputStack = new Stack();
        outputStack = new Stack();
    }

    public static void push(int x) {
        inputStack.push(x);
    }

    public static int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        if (outputStack.isEmpty()) return -1;
        else return (int) outputStack.pop();
    }

    public static int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        if (outputStack.isEmpty()) return -1;
        else return (int) outputStack.peek();
    }

    public static boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("Pop: " + queue.pop()); // Output: Pop: 1
        System.out.println("Peek: " + queue.peek()); // Output: Peek: 2
        System.out.println("Is Empty: " + queue.empty()); //
    }

}
