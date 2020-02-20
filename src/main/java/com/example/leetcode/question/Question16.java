package com.example.leetcode.question;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author shentao
 */
public class Question16 {

    /*public static int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        BigDecimal i = factorial(new BigDecimal(n));
        System.out.println(i);
        char[] chars = i.toString().toCharArray();
        int result = chars.length - 1;
        while (chars[result] == '0') {
            result--;
        }
        return chars.length - result - 1;
    }

    private static BigDecimal factorial(BigDecimal i) {
        if (i.compareTo(new BigDecimal(1)) == 0) {
            return new BigDecimal(1);
        } else {
            return i.multiply(factorial(i.subtract(BigDecimal.valueOf(1))));
        }
    }*/

    public static int trailingZeroes(int n) {
        int result = 0;
        while (n >= 5) {
            n /= 5;
            result += n;
        }
        return result;
    }

    public static void main(String[] args) {
        int zeroes = trailingZeroes(3);
        System.out.println(zeroes);
    }
}
