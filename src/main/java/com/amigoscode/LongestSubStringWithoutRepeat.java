package com.amigoscode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {

    public int lengthOfLongestSubString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            if (map.containsKey(rightChar)) {
                start = Math.max(start, map.get(rightChar) + 1);
            }
            map.put(rightChar, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;

    }


    public static void main(String[] args) {
        LongestSubStringWithoutRepeat longestSubStringWithoutRepeat = new LongestSubStringWithoutRepeat();
        System.out.println(longestSubStringWithoutRepeat.lengthOfLongestSubString("pwwkew"));
    }

}
