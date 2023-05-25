package com.ds;

/*
Here are some common time complexities in computer science, along with examples:

1. O(1) - Constant Time: An algorithm with constant time complexity will always take the same amount of time, regardless of the input size.
    Example: Accessing an element in an array or a HashMap by its index or key.

2. O(log n) - Logarithmic Time: An algorithm with logarithmic time complexity will take time proportional to the logarithm of the input size.
    Example: Binary search in a sorted array.

3. O(n) - Linear Time: An algorithm with linear time complexity will take time proportional to the input size.
    Example: Linear search in an unsorted array.

4. O(n log n) - Log-Linear Time: An algorithm with log-linear time complexity will take time proportional to the product of the input size and the logarithm of the input size.
    Example: Merge sort.

5. O(n^2) - Quadratic Time: An algorithm with quadratic time complexity will take time proportional to the square of the input size.
    Example: Selection sort.

6. O(n^3) - Cubic Time: An algorithm with cubic time complexity will take time proportional to the cube of the input size.
    Example: Matrix multiplication.

7. O(2^n) - Exponential Time: An algorithm with exponential time complexity will take time proportional to 2 raised to the power of the input size.
    Example: Solving the Traveling Salesman Problem using brute-force search.

Note that the above time complexities are listed in increasing order of complexity.
It's generally desirable to use algorithms with lower time complexities whenever possible, as they are more efficient and scale better with larger input sizes.
 */

import java.util.Arrays;

public class TimeComplexities {

    // O(1): Constant Time Complexity
    // This function takes constant time
    // as it always performs a fixed number of operations
    public int addNumbers(int a, int b) {
        return a + b;
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //O(log n): Logarithmic Time Complexity
    // This function performs binary search
    // and takes logarithmic time to execute
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // O(n): Linear Time Complexity
    // This function traverses an array of n elements
    // and takes linear time to execute
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // O(n log n) - Linearithmic Time:
    // This function performs merge sort
    // and takes linearithmic time to execute
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }
    private static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // O(n^2) - Quadratic Time:
    // This function performs bubble sort
    // and takes quadratic time to execute
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // O(n^3) - Cubic Time:
    // This function computes the sum of all subarrays of an integer array
    // with cubic time complexity O(n^3)
    public static int sumSubArrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }
}
