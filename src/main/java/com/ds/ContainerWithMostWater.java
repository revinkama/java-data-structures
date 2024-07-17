package com.ds;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxArea(height);
        System.out.println("Maximum Area: " + max); // Output:
    }

    public static int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxArea = 0;
        while(head < tail) {
            int minHeight = Math.min(height[head], height[tail]);
            int currentArea = minHeight * (tail - head);
            maxArea = Math.max(maxArea, currentArea);
            if (height[tail] > height[head]) {
                head++;
            } else {
                tail--;
            }

        }
        return maxArea;
    }

}
