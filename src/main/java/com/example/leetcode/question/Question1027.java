package com.example.leetcode.question;

        import java.util.HashMap;
        import java.util.Map;

/**
 * Question1027
 *
 * @author shentao
 * @date 2020/2/24
 */
public class Question1027 {
    public static int longestArithSeqLength(int[] A) {
        int max = 2;
        int gc = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            int a = A[i + 1] - A[0];
        }
        return max;
    }


    public static void main(String[] args) {
        int i = longestArithSeqLength(new int[]{9, 4, 7, 2, 10});
        System.out.println(i);
    }
}
