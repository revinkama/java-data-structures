package com.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class MinimalSubArray {

    public static void main(String[] args ) throws Exception {
        // Output the solution to the console
        System.out.println(codeHere(5, new String[]{"1", "2", "2", "3", "1"}));
    }
    public static String codeHere(int length, String[] arr) {
        // Use this function to write your solution;
        char first = 0;
        for (int i = 1; i < length; i++) {
            if(Objects.equals(arr[first], arr[i])) {
                return arr[i];
            }
            first++;
        }
        return null;
    }

}
