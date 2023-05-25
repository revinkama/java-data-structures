package com.ds;

public class MatrixExamples {

    public void search(int[][] matrix, int n, int x) {
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("x found at - " + i + ", " + j);
                return;
            }
            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }

    public void spiralPrint(int[][] matrix, int r, int c) {
        int i, k = 0, l = 0;
        while (k < r && l < c) {
            // left to right
            for (int j = l; j < c; j++) {
                System.out.print(matrix[k][j] + " ");
            }
            k++;
            // top to bottom
            for (int j = k; j < r; j++) {
                System.out.print(matrix[j][c-1] + " ");
            }
            c--;
            // right to left
            if (k < r) {
                for (int j = c - 1; j >= l ; j--) {
                    System.out.print(matrix[r-1][j] + " ");
                }
                r--;
            }
            if (l < c) {
                for (int j = r - 1; j >= k; j--) {
                    System.out.print(matrix[j][l] + " ");
                }
                l++;
            }
        }

    }

        public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };
        MatrixExamples matrixExamples = new MatrixExamples();
        matrixExamples.search(matrix, 4, 32);
        matrixExamples.spiralPrint(matrix, 4, 4);
    }
}
