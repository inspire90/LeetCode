package com.example.leetcode.question;

/**
 * Question413
 *
 * @author shentao
 * @date 2020/3/6
 */
public class Question413 {
    public static int numberOfArithmeticSlices(int[] A) {
        int i = 0;
        int count = 0;
        int num = 3;
        while (num <= A.length) {
            int j = i;
            int c = A[j + 1] - A[j];
            boolean flag = true;
            System.out.println(j + "----" + num);
            while (j < num + i - 1) {
                if (A[j + 1] - A[j] == c) {
                    j++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
            if (i + num == A.length) {
                num++;
                i = 0;
            } else if (i + num > A.length) {
                break;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        System.out.println(i);
    }
}
