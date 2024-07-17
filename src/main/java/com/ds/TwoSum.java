package com.ds;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {


    public int[] twoSumReturn(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (sum < target) {
                left++;
            } else right--;
        }
        return new int[0];
    }

    public int[] twoSumOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
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
        System.out.println("Two Sum with While Loop and Pointers");
        sum.printArray(sum.twoSumReturn(arr, 10));
        System.out.println("Two Sum Optimized");
        sum.printArray(sum.twoSumOptimized(arr, 10));
    }

}
