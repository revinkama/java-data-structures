package com.ds;

import java.util.ArrayList;

public class FindTheMissingNumber {

    public static int findMissingNumber(int[] array) {
        int n = array.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5};
        System.out.println(findMissingNumber(array));
    }
}
