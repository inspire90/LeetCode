package com.example.leetcode.question;

import java.util.Arrays;

/**
 * Question976
 *
 * @author shentao
 * @date 2020/3/3
 */
public class Question976 {
    public static int largestPerimeter(int[] A) {
        if (A.length >= 3) {
            Integer[] nums = Arrays.stream(A).boxed().toArray(Integer[]::new);
            Arrays.sort(nums, (o1, o2) -> o2 - o1);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] < nums[i + 1] + nums[i + 2]) {
                    return nums[i] + nums[i + 1] + nums[i + 2];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = largestPerimeter(new int[]{3, 2, 3, 4});
        System.out.println(i);
    }
}
