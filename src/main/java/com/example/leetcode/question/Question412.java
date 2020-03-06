package com.example.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * Question412
 *
 * @author shentao
 * @date 2020/3/1
 */
public class Question412 {
    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        list.forEach(System.out::println);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String fizz = "Fizz", buzz = "Buzz";
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add(fizz + buzz);
            } else if (i % 3 == 0) {
                list.add(fizz);
            } else if (i % 5 == 0) {
                list.add(buzz);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
