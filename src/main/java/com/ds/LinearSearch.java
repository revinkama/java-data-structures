package com.ds;

public class LinearSearch {

    public int linearSearch(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int[] nums = {1, 10, 20, 47, 59, 65, 75, 88, 99};

        System.out.println("Linear Search of (65): " + linearSearch.linearSearch(nums, nums.length, 65));
    }

}
