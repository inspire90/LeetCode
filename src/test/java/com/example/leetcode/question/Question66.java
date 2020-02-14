package com.example.leetcode.question;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author shentao
 */
public class Question66 {

    public static void main(String[] args) {
        int[] result = plusOne(new int[]{2, 9});
        Arrays.stream(result).boxed().collect(Collectors.toList()).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i]++;
        carry(digits, i);
        if (digits[0] == 10) {
            int[] result = new int[i + 2];
            result[0] = 1;
            result[1] = 0;
            return result;
        }
        return digits;
    }

    private static void carry(int[] digits, int i) {
        if (digits[i] == 10 && i != 0) {
            digits[i - 1]++;
            digits[i] = 0;
        }
        if (i - 1 > 0) {
            carry(digits, i - 1);
        }
        return;
    }

}
