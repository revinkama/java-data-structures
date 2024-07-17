package com.ds;

public class AreAnagrams {

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] letterCounts = new int[256]; // ASCII character set assumption

        for (char c : s1.toCharArray()) {
            letterCounts[c]++;
        }
        for (char c : s2.toCharArray()) {
            if (--letterCounts[c] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example strings
        String s1 = "listen";
        String s2 = "silent";

        // Call the areAnagrams method and print the result
        boolean result = areAnagrams(s1, s2);
        System.out.println("Are \"" + s1 + "\" and \"" + s2 + "\" anagrams? " + result);
    }

}
