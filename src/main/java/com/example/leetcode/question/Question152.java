package com.example.leetcode.question;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Question152
 *
 * @author shentao
 * @date 2020/2/28
 */
public class Question152 {
    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = nums[0];
        map.put(0, max);
        int i = 0;
        while (i < nums.length - 1) {
            if (max * nums[i] * nums[i + 1] > max) {
                max *= nums[i] * nums[i + 1];
                map.put(i, max);
                i++;
            } else if (max * nums[i] > max) {
                max *= nums[i];
                map.put(i, max);
            } else {
                max = 1;
            }
            i++;
        }
        LinkedHashMap<Integer, Integer> linkedHashMap = map.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Integer key = linkedHashMap.keySet().iterator().next();
        return linkedHashMap.get(key);
    }

    public static void main(String[] args) {
        int i = maxProduct(new int[]{0, 2});
        System.out.println(i);
    }
}
