package com.example.leetcode.question;

import java.util.Arrays;

/**
 * Question259
 *
 * @author shentao
 * @date 2020/3/4
 */
public class Question259 {
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
        System.out.println(i);
    }
}
