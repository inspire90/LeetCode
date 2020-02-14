package com.example.leetcode.question;

import java.util.Arrays;

/**
 * @ClassName: Question88
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/10  0:09
 */
public class Question88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        Arrays.stream(nums1).boxed().forEach(System.out::println);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
