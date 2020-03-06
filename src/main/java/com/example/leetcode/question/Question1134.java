package com.example.leetcode.question;

/**
 * Question1134
 *
 * @author shentao
 * @date 2020/2/20
 */
public class Question1134 {
    public static boolean isArmstrong(int N) {
        int len = String.valueOf(N).length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int w = String.valueOf(N).charAt(i) - '0';
            sum += Math.pow(w, len);
        }
        return sum == N;
    }

    public static void main(String[] args) {
        boolean b = isArmstrong(123);
        System.out.println(b);
    }
}
