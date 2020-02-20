package com.example.leetcode.question;

import java.util.*;

/**
 * @ClassName: Question27
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/12  21:39
 */
public class Question27 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 25, 21, 2, 20, 7, 24, 9, 24, 24, 6, 22, 5, 1, 26, 17, 18, 29, 25, 9, 8, 27, 6, 26, 8, 5, 27, 5, 0, 29, 26, 29, 24, 18, 23, 14, 25, 17, 15, 20, 11, 22, 4, 17, 15, 0, 26, 3, 21, 21, 12, 0, 10, 10, 26, 19, 15, 23, 16, 7, 14, 12, 7, 8, 0, 0, 14, 26, 18, 22, 8, 21, 6, 12, 0, 21, 4, 26, 16, 26, 18, 21};
        int num = removeElement(nums, 26);
        System.out.println(num);
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }

    public static int removeElement(int[] nums, int val) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                map.put(i, val);
                count++;
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int num = nums.length - 1;
            Integer k = it.next();
            while (num >= 0) {
                if (nums[num] != val && num > k) {
                    nums[k] = nums[num];
                    nums[num] = val;
                    num--;
                    break;
                } else {
                    num--;
                }
            }
        }
        return nums.length - count;
    }
}
