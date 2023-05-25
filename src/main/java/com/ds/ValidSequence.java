package com.ds;

public class ValidSequence {

    public boolean isSubSequence(String str, String seq) {
        int i = 0;
        int j = 0;
        while (i < str.length() && j < seq.length()) {
            if (str.charAt(i) == seq.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == seq.length();
    }

    public static void main(String[] args) {
        ValidSequence validSequence = new ValidSequence();
        System.out.println(validSequence.isSubSequence("abcde", "ace"));
    }

}
