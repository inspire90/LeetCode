package com.example.leetcode.question;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question989
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/9  18:07
 */
public class Question989 {
    public static void main(String[] args) {
        int k = 34;
        int[] A = new int[]{1, 2, 0, 0};
        List<Integer> list = addToArrayForm(A, k);
        list.forEach(System.out::println);
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            stringBuilder.append(A[i]);
        }
        BigDecimal temp = new BigDecimal(stringBuilder.toString());
        temp = temp.add(new BigDecimal(K));
        String string = String.valueOf(temp);
        for (int i = 0; i < string.length(); i++) {
            result.add(Integer.valueOf(string.substring(i, i + 1)));
        }
        return result;
    }
}
