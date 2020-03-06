package com.example.leetcode.question;

import java.util.Arrays;

/**
 * Question167
 *
 * @author shentao
 * @date 2020/3/1
 */
public class Question167 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 18);
        Arrays.stream(ints).boxed().forEach(System.out::println);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 1, j = numbers.length;
        while (numbers[i - 1] + numbers[j - 1] != target) {
            if (numbers[i - 1] + numbers[j - 1] < target) {
                i++;
            } else if (numbers[i - 1] + numbers[j - 1] > target) {
                j--;
            }
        }
        return new int[]{i, j};
    }
}
