package com.ds;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize the maximum subarray sum
        int currentSum = nums[0]; // Initialize the current subarray sum

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate the current subarray sum by adding the current element or starting a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum subarray sum if the current subarray sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(nums);
        System.out.println("Maximum subarray sum is: " + maxSum);
    }

}
