package com.example.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * Question1133
 *
 * @author shentao
 * @date 2020/2/25
 */
public class Question1133 {
    public static int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>(A.length);
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int count = map.get(A[i]);
                map.put(A[i], ++count);
            } else {
                map.put(A[i], 1);
            }
        }
        int max = -1;
        for (Integer i : map.keySet()) {
            int value = map.get(i);
            if (value == 1) {
                if (i > max) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1});
        System.out.println(i);
    }
}
