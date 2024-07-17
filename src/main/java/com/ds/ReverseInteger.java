package com.ds;

public class ReverseInteger {

    public long reverse(int number) {
        boolean isNegative = number < 0;

        if (isNegative) {
            number = number * -1;
        }

        long reverse = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        return isNegative ? reverse * -1 : reverse;
    }

    public String reverseToString(int number) {
        String num = String.valueOf(number);
        char[] chars = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1234));
        System.out.println(Integer.parseInt(reverseInteger.reverseToString(1234)));
    }
}
