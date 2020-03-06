package com.example.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * Question57_ii
 *
 * @author shentao
 * @date 2020/3/6
 */
public class Question57_ii {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        while (i <= target / 2) {
            int j = i;
            int sum = 0;
            while (sum <= target) {
                if (sum == target) {
                    int[] temp = new int[j - i];
                    int count = 0;
                    for (int k = i; k < j; k++) {
                        temp[count] = k;
                        count++;
                    }
                    list.add(temp);
                }
                sum += j;
                j++;
            }
            i++;
        }
        int[][] result = list.toArray(new int[0][0]);
        return result;
    }

    public static void main(String[] args) {
        findContinuousSequence(10);
    }
}
