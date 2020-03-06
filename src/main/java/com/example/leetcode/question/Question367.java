package com.example.leetcode.question;

/**
 * Question367
 *
 * @author shentao
 * @date 2020/3/6
 */
public class Question367 {
    public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (i * i != num && i <= num / 2 + 1) {
            i++;
        }
        return i * i == num;
    }

    public static void main(String[] args) {
        boolean b = isPerfectSquare(14);
        System.out.println(b);
    }
}
