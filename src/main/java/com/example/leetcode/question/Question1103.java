package com.example.leetcode.question;

import java.util.Arrays;

/**
 * Question1103
 *
 * @author shentao
 * @date 2020/3/5
 */
public class Question1103 {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int sum = 1;
        int i = 0;
        while (true) {
            if (candies - sum > 0) {
                candies -= sum;
            } else {
                break;
            }
            result[i % num_people] += sum;
            i++;
            sum++;
        }
        result[i % num_people] += candies;
        return result;
    }

    public static void main(String[] args) {
        int[] ints = distributeCandies(10, 3);
        Arrays.stream(ints).boxed().forEach(System.out::println);
    }
}
