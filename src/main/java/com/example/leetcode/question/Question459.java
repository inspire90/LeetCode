package com.example.leetcode.question;

/**
 * Question459
 *
 * @author shentao
 * @date 2020/2/22
 */
public class Question459 {
    public static void main(String[] args) {
        boolean b = repeatedSubstringPattern("aabaaba");
        System.out.println(b);
    }

    public static boolean repeatedSubstringPattern(String s) {
        boolean result = false;
        int len = s.length();
        int i = 1;
        int step = 1;
        String stepStr = s.substring(0, step);
        while (i * step < len && step <= len / 2) {
            //System.out.println(i + "," + step + "," + len);
            String temp = s.substring(i * step, (i + 1) * step);
            if (stepStr.equals(temp)) {
                result = true;
                i++;
            } else {
                result = false;
                i = 1;
                do {
                    step++;
                }
                while (len % step != 0 && step <= len / 2);
                stepStr = s.substring(0, step);
            }
        }
        return result;
    }
}
