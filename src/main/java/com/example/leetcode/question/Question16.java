package com.example.leetcode.question;

import java.util.Arrays;

/**
 * Question16
 *
 * @author shentao
 * @date 2020/2/21
 */
public class Question16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int abs = Integer.MAX_VALUE;
        for (int l = 0; l < nums.length - 1; l++) {
            int i = l + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[l] + nums[j];
                int temp = Math.abs(sum - target);
                if (temp < abs) {
                    abs = temp;
                    result = sum;
                }
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{0, 2, 1, -3}, 1);
        System.out.println(i);
    }
}
