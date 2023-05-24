package com.amigoscode;

public class BinarySearch {

    public int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (arr[middle] == x) {
                return middle;
            }
            if (x < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (target < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
         return low;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1, 10, 20, 47, 59, 65, 75, 88, 99};
        System.out.println("Binary Search of Array for (65): " + bs.binarySearch(nums, 65));
        System.out.println("Search Insert(30): " + bs.searchInsert(nums, 30));
    }
}
