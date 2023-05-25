package com.ds;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] arr) {
        int[] result = new int[arr.length];
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            result[i] = temp;
            temp = temp * arr[i];
        }
        temp = 1;
        for (int i = arr.length-1; i >= 0 ; i--) {
            result[i] = result[i] * temp;
            temp = temp * arr[i];
        }
        return result;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.printArray(productOfArrayExceptSelf.productExceptSelf(arr));
    }

}
