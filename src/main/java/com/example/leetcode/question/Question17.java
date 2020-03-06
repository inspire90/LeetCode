package com.example.leetcode.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question17
 *
 * @author shentao
 * @date 2020/2/21
 */
public class Question17 {
    static Map<Integer, String> nums = new HashMap<>(8);

    static {
        nums.put(2, "abc");
        nums.put(3, "def");
        nums.put(4, "ghi");
        nums.put(5, "jkl");
        nums.put(6, "mno");
        nums.put(7, "pqrs");
        nums.put(8, "tuv");
        nums.put(9, "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if ("".equals(digits) || digits == null) {
            return result;
        }
        int first = Integer.parseInt(digits.substring(0, 1));
        String s = nums.get(first);
        for (char c : s.toCharArray()) {
            result.add(c + "");
        }
        List<String> list = callBack(result, digits, 1);
        return list;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("234");
        list.forEach(System.out::println);
    }

    public static List<String> packageWords(String digit1, String digit2) {
        List<String> result = new ArrayList<>();
        for (int j = 0; j < digit2.length(); j++) {
            result.add(digit1 + digit2.substring(j, j + 1));
        }
        return result;
    }

    public static List<String> callBack(List<String> strings, String digits, int i) {
        List<String> result = new ArrayList<>();
        if (i < digits.length()) {
            String digit = nums.get(digits.charAt(i) - '0');
            for (String string : strings) {
                result.addAll(packageWords(string, digit));
            }
            return callBack(result, digits, ++i);
        } else {
            return strings;
        }
    }
}
