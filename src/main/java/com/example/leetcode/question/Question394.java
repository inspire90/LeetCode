package com.example.leetcode.question;

import java.util.Stack;

/**
 * @author shentao
 */
public class Question394 {
    public static void main(String[] args) {
        String s = decodeString("3[a2[c]]");
        System.out.println(s);
    }

    public static String decodeString(String s) {
        int repeat = 0;
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            repeat = Integer.parseInt(s.substring(0, 1));
        } else {
            return "";
        }
        String s1 = recurrence(repeat, s);
        return s1;
    }

    private static String recurrence(int repeat, String s) {
        int begin = s.indexOf('[');
        int end = s.lastIndexOf(']');
        if (begin != -1 && end != -1) {
            String string = s.substring(begin + 1, end);
            if (string.indexOf('[') != -1) {
                StringBuilder sbf = new StringBuilder();
                for (int i = 0; i < repeat; i++) {
                    sbf.append(string.substring(0, begin)).append(recurrence(Integer.parseInt(string.substring(begin, begin + 1)), string));
                }
                return sbf.toString();
            } else {
                StringBuilder sbf = new StringBuilder();
                for (int i = 0; i < repeat; i++) {
                    sbf.append(string);
                }
                return sbf.toString();
            }
        }
        return "";
    }

    private static String combineString(int repeat, String repeatStr) {
        StringBuilder sbf = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sbf.append(repeatStr);
        }
        return sbf.toString();
    }
}
