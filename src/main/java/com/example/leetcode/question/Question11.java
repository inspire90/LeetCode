package com.example.leetcode.question;

public class Question11 {
    public static void main(String[] args) {
        int i = maxArea(new int[]{2, 3, 4, 5, 18, 17, 6});
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                int sum = sumHeight(i, j, height);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static int sumHeight(int i, int j, int[] height) {
        //System.out.println(i + "," + j);
        int sum = height[i] < height[j] ? (j - i) * height[i] : (j - i) * height[j];
        return sum;
    }
}
