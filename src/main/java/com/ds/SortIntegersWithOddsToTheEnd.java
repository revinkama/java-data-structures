package com.ds;

import java.util.Arrays;

public class SortIntegersWithOddsToTheEnd {

    public static void sortArrayWithOddsAtEnd(int[] arr) {
        int n = arr.length;
        int oddIndex = n - 1;
        for (int i = 0; i < oddIndex;) {
            if (arr[i] % 2 == 0) {
                i++;
            } else {
                swap(arr, i, oddIndex);
                oddIndex--;
            }
        }
        Arrays.sort(arr, oddIndex + 1, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        sortArrayWithOddsAtEnd(arr);
    }


}
