package com.example.leetcode.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question268
 *
 * @author shentao
 * @date 2020/2/27
 */
public class Question268 {
    public static void main(String[] args) {
        int missingNumber = missingNumber(new int[]{1});
        System.out.println(missingNumber);
    }

    /*public static int missingNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }*/
    public static int missingNumber(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
}
