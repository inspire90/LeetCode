package com.example.leetcode.question;

/**
 * Question233
 *
 * @author shentao
 * @date 2020/3/3
 */
public class Question233 {

    public static int countDigitOne(int n) {
        int count = 0;
        if (n > 0) {
            count = 1;
            for (int i = 10; i <= n; i++) {
                String str = String.valueOf(i);
                if (str.indexOf('1') > -1) {
                    count += str.length() - str.replace("1", "").length();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int one = countDigitOne(13);
        System.out.println(one);
    }
}
