package com.ds;

import java.util.HashSet;

public class SortedArrayMissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};

        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number is: " + missingNumber);

        int missingNumberOpt = findMissingNumberOptimized(arr);
        System.out.println("Missing number optimized is: " + missingNumberOpt);
    }

    public static int findMissingNumber(int[] arr) {
        HashSet<Integer> integerHashSet = new HashSet<>();

        for (int i = 0; i < arr.length-1; i++) {
            integerHashSet.add(arr[i]);
        }

        for (int i = 1; i <= arr.length; i++) {
            if (!integerHashSet.contains(i)) return i;
        }

        return -1;
    }

    public static int findMissingNumberOptimized(int[] arr) {
        // Calculate the total sum and get the natural numbers
        int size = arr.length + 1;
        int totalSum = size * (size + 1) / 2;

        int arraySum = 0;
        for (int num: arr) {
            arraySum += num;
        }

        return totalSum - arraySum;
    }

}
