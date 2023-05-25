package com.ds;

public class DutchNationalFlag {

    public int[] sortFlag(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        int[] result = new int[arr.length];
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                result[i] = arr[i];
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);
                result[i] = arr[i];
                k--;
            }
        }
        return result;
    }

    private void swap(int[] arr, int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        int[] arr = {2, 0, 2, 2, 0, 1, 1};
        dutchNationalFlag.printArray(dutchNationalFlag.sortFlag(arr));
    }

}
