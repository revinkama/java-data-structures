package com.amigoscode;

import java.util.Arrays;

public class TwoSum {


    public int[] twoSumReturn(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            } else if (sum < target) {
                left++;
            } else right--;
        }
        return new int[0];
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] arr = {2, 11, 5, 10, 7, 8};
        sum.printArray(sum.twoSumReturn(arr, 10));
    }

}
