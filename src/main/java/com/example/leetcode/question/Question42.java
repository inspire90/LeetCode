package com.example.leetcode.question;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Question42 {
    public static void main(String[] args) {
//        int i = trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3});
        int i = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(i);
    }

    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int begin = 0;
        int end = height.length - 1;
        while (height[begin] <= height[begin + 1]) begin++;
        while (height[end] <= height[end - 1]) end--;
        if (begin == end) {
            return 0;
        }
        int sum = 0;
        int max = 0, index = 0;
        for (int i = begin; i <= end; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        Map<Integer, Integer> left = new HashMap<>();
        for (int i = begin + 1; i < index; i++) {
            if (height[i] > height[begin]) {
                left.put(i, height[i]);
            }
        }
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = index; i < end; i++) {
            if (height[end] < height[i]) {
                right.put(i, height[i]);
            }
        }
        return sum;
    }

    private static int sumRain(int begin, int end, int[] height) {
        int abs = height[begin] > height[end] ? height[end] : height[begin];
        abs = abs * (end - begin - 1);
        for (int i = begin + 1; i < end; i++) {
            abs -= height[i];
        }
        System.out.println("起始位：" + begin + ",结束：" + end + ",雨水" + abs);
        return abs;
    }


}
