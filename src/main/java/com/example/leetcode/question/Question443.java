package com.example.leetcode.question;

import java.util.Arrays;

/**
 * Question443
 *
 * @author shentao
 * @date 2020/2/19
 */
public class Question443 {
    public static void main(String[] args) {
        int compress = compress(new char[]{'a','a','a','b','b','a','a'});
        System.out.println(compress);
    }

    public static int compress(char[] chars) {
        //Arrays.sort(chars);
        int i = 0, count = 1, begin = 1;
        char c = chars[0];
        while (i < chars.length - 1) {
            if (chars[i] != chars[i + 1]) {
                c = chars[i + 1];
                begin = assign(chars, count, begin);
                count = 1;
                chars[begin] = c;
                begin++;
            } else {
                count++;
            }
            i++;
        }
        begin = assign(chars, count, begin);
        return begin;
    }

    private static int assign(char[] chars, int count, int begin) {
        if (count <= 1) {
            return begin;
        }
        if (count <= 9) {
            chars[begin] = (char) (count + 48);
            begin++;
        } else {
            String temp = String.valueOf(count);
            int t = 0;
            while (t < temp.length()) {
                chars[begin + t] = temp.charAt(t);
                t++;
            }
            begin += t;
        }
        return begin;
    }
}
