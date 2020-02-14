package com.example.leetcode.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question26
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/9  16:52
 */
public class Question26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>(16);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                continue;
            } else {
                result.put(nums[i], nums[i]);
                nums[count] = nums[i];
                count++;
            }
        }
        return result.size();
    }
}
