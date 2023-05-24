package com.amigoscode;

public class MergeSort {

    public void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }


    public int[] merge(int[] arr, int[] arr2, int n, int m) {
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr[i] < arr2[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            result[k] = arr[i];
            i++;
            k++;
        }
        while (j < m) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {2, 5, 7, 23};
        int[] arr2 = {3, 4, 9};
        mergeSort.printArray(mergeSort.merge(arr, arr2, arr.length, arr2.length));

    }

}
