package com.ds;

import java.util.Scanner;

public class IntegerToRomanNumeral {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        String result = intToRoman(num);
        System.out.println("The Roman numeral equivalent of " + num + " is " + result);
    }

    public static String intToRoman(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < romanNumerals.length; i++) {
            while (num >= values[i]) {
                sb.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

}
