package com.amigoscode;

import java.util.Arrays;

public class ArrayExamples {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int findTheMissingNumber(int[] arr) {
        int num = arr.length + 1;
        int sum = num * (num + 1) / 2;
        for (int number: arr) {
            sum = sum - number;
        }
        return sum;
    }

    public int[] resizeArray(int[] arr, int capacity) {
        int[] tempArr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        return tempArr;
    }

    public void moveAllZerosToEnd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[count] == 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
            }
            if (arr[count] != 0){
                count++;
            }
        }
    }

    public int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int minValueInArray(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
        return min;
    }

    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void removeEvenIntegers(int[] arr) {
        int oddCount = 0;

        for (int k : arr) {
            if (k % 2 != 0) {
                oddCount++;
            }
        }

        int[] oddArray = new int[oddCount];
        int index = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddArray[index] = j;
                index++;
            }
        }
        System.out.println(Arrays.toString(oddArray));
    }

    public void arrayDemo() {
        int[] myArray = new int[7];
        myArray[0] = 0;
        myArray[1] = 2;
        myArray[2] = 3;
        myArray[3] = 5;
        myArray[4] = 7;
        myArray[5] = 9;
        myArray[6] = 10;

        System.out.println("Linear Searching for (123) in Array Index: " + linearSearch(myArray, 7, 123));
        System.out.println("Linear Searching for (7) in Array Index: " + linearSearch(myArray, 7, 7));

        printArray(myArray);
        removeEvenIntegers(myArray);
        reverseArray(myArray, 0, myArray.length - 1);
        System.out.print("Reversed Array: ");
        printArray(myArray);
        System.out.println("Min Value: " + minValueInArray(myArray));
        System.out.println("Second Max: " + findSecondMax(myArray));
        moveAllZerosToEnd(myArray, 0);
        System.out.print("Zero's moved to the end: ");
        printArray(myArray);

        System.out.println("Size of original array: " + myArray.length);
        System.out.println("Size of resized array: " + resizeArray(myArray, myArray.length * 2).length);

        int[] numbers = new int[] {2, 4, 1, 8, 6, 3, 7};
        System.out.print("Missing Number in Array ");
        printArray(numbers);
        System.out.println(findTheMissingNumber(numbers));

        System.out.println("Palindrome Word (MADAM): " + isPalindrome("madam"));
        System.out.println("Palindrome Word (THAT): " + isPalindrome("that"));

    }

    public int linearSearch(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        ArrayExamples arrayExamples = new ArrayExamples();
        arrayExamples.arrayDemo();
    }
}
