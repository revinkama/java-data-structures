package com.ds;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Not using a queue");
        for (int num : result) {
            System.out.print(num + " ");
        }

        int[] res = maxSlidingWindowOptimized(nums, k);
        System.out.println("\n Using a queue");
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    // Not optimized
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Remove the element that is out of the current window
            if (i - maxIndex >= k) {
                maxIndex = -1;
                max = Integer.MIN_VALUE;
            }

            // Update the maximum element and its index within the current window
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }

            // Add the maximum element to the result array when the window size is equal to k
            if (i >= k - 1) {
                result[resultIndex++] = max;
            }
        }

        return result;
    }

    public static int[] maxSlidingWindowOptimized(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // Add the maximum element for the current window to the result
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

}
