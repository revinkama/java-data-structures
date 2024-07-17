package com.ds;

import java.util.HashMap;

public class TwoStringAnagrams {

    // Given 2 strings s and t, return true if t is an anagram of s

    public static boolean areAnagrams(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                int count = map.get(sChars[i]) + 1;
                map.put(sChars[i], count);
            } else {
                map.put(sChars[i], 1);
            }
        }

        for (int i = 0; i < tChars.length; i++) {
            if (map.containsKey(tChars[i])) {
                int count = map.get(tChars[i]) - 1;
                map.put(tChars[i], count);
                if (count == 0) {
                    map.remove(tChars[i]);
                }
            } else return false;
        }

        return map.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("race", "nagaram"));
    }


}
