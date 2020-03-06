package com.example.leetcode.question;

/**
 * Question70
 *
 * @author shentao
 * @date 2020/2/22
 */
public class Question70 {
    public static int climbStairs(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += 2) {
                System.out.println(i + "," + j);
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
    }
}
