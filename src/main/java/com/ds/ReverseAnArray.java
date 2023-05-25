package com.ds;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.print("Original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int[] reversedArr = reverse(arr);

        System.out.print("\nReversed array: ");
        for (int i = 0; i < reversedArr.length; i++) {
            System.out.print(reversedArr[i] + " ");
        }
    }

    public static int[] reverse(int[] arr) {
        int[] reversedArr = new int[arr.length];
        int count = 0;
        for (int i = arr.length-1; i >=0; i--) {
            reversedArr[count] = arr[i];
            count++;
        }

//        for (int i = 0; i < arr.length; i++) {
//            reversedArr[i] = arr[arr.length - i - 1];
//        }

        return reversedArr;
    }

}
