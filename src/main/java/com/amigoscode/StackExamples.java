package com.amigoscode;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackExamples {

    private ListNode top;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public StackExamples() {
        top = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public String reverseAString(String string) {
        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
        for (char c: chars) {
            stack.push(c);
        }
        for (int i = 0; i < string.length(); i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    boolean areBracketsCorrectlyClosed(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackExamples stack = new StackExamples();
        stack.push(13);
        stack.push(15);
        stack.push(20);

        System.out.println("Last Inserted Node: "+stack.peek());
        stack.pop();
        System.out.println("Last Inserted Node After Pop: "+stack.peek());

        System.out.println("Reversing a String(Hello): " + stack.reverseAString("Hello"));

        int[] arr = new int[] {4, 7, 3, 4, 8, 1};
        int[] result = stack.nextGreaterElement(arr);
        Arrays.stream(result).forEach(number -> {
            System.out.print(number + " ");
        });

        System.out.println();
        System.out.println("Checking Brackets are closed []{}(): " + stack.areBracketsCorrectlyClosed("[]{}()"));
        System.out.println("Checking Brackets are closed [{}(: " + stack.areBracketsCorrectlyClosed("[{}("));

    }

}
