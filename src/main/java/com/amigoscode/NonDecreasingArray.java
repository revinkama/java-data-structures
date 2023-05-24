package com.amigoscode;

public class NonDecreasingArray {

    // Problem: given an integer array num of length n write a method to check if the array could become non-decreasing by modifying at most one element in the array
// **non-decreasing: if nums[i] <= nums[i + 1] holds for every i such that 0 <= i <= (n - 2)
// Examples:
// 1. int[] nums = new int[3, 1, 2]
// output = true (you can modify 3 to be 1 --> [1, 1, 2])
// 2. int[] nums = new int[3, 2, 1]
// output = false (more than one element would need to be modified)
// 3. int[] nums = new int[1, 2, 3, 4, 4, 4]
// output = false (more than one element would need to be modified)


    public static boolean canArrayBeNonDecreasing(int[] nums) {
        int counter = 0;
        for(int i=0; i<nums.length-1; i++) {
            int nextDigit = i + 1;
            if(nums[i] > nextDigit) {
                if(i != 0 && nums[i-1] > nextDigit) {
                    nums[nextDigit] = nums[i];
                } else {
                    nums[i] = nums[nextDigit];
                }
                counter++;
            }
        }

        return counter > 1 ? false : true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 3};
        System.out.println(canArrayBeNonDecreasing(arr));
    }

}
