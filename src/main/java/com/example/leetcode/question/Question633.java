package com.example.leetcode.question;

/**
 * Question633
 *
 * @author shentao
 * @date 2020/3/5
 */
public class Question633 {
    public static boolean judgeSquareSum(int c) {
        int a = 0;
        while (a <= Math.sqrt(c)) {
            double i = Math.sqrt(c - a * a);
            if (i == (int) i) {
                return true;
            } else {
                a++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = judgeSquareSum(4);
        System.out.println(b);
    }
}
