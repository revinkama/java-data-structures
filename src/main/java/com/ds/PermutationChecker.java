package com.ds;

import java.util.Arrays;

public class PermutationChecker {
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        boolean isPermutation = isPermutation(s1, s2);

        String s3 = "abcdef";
        String s4 = "dcbafe";
        boolean isPermutation2 = isPermutation(s3, s4);

        String s5 = "racecar";
        String s6 = "carrace";
        boolean isPermutation3 = isPermutation(s5, s6);

        System.out.println(isPermutation);
        System.out.println(isPermutation2);
        System.out.println(isPermutation3);

    }
}
