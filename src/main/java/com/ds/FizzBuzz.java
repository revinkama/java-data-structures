package com.ds;

public class FizzBuzz {

    public static void main(String[] args) {
        int n = 100; // You can change this to any other number as required
        fizzBuzz(n);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0 && i % 11 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 11 == 0) {
                System.out.println("Fizz");
            } else if (i % 7 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
