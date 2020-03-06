package com.example.leetcode.question;

/**
 * Question263
 *
 * @author shentao
 * @date 2020/3/2
 */
public class Question263 {
    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        boolean ugly = isUgly(6);
        System.out.println(ugly);
    }
}
