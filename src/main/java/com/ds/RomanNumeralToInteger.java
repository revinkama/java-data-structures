package com.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    This program first prompts the user to enter a Roman numeral,
    and then passes the input string to the romanToInt method.
    The romanToInt method uses a HashMap to map each Roman numeral character
    to its corresponding integer value, and then iterates through the
    input string one character at a time. If the current character
    has a smaller value than the next character,
    it subtracts the current value from the result;
    otherwise, it adds the current value to the result.
    Finally, the method returns the resulting integer value.
 */
public class RomanNumeralToInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String roman = sc.nextLine();
        int result = romanToInt(roman);
        System.out.println("The integer value of " + roman + " is " + result);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanToIntMap.get(s.charAt(i));
            if (i < s.length() - 1 && currentValue < romanToIntMap.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        return result;
    }

}
