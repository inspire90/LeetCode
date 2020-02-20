package com.example.leetcode.question;

import java.util.Stack;

public class Question946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length == 0 || pushed.length == 0) {
            return true;
        }
        int begin = 0;
        int end = popped.length - 1;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        do {
            stack.push(pushed[begin]);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
            begin++;
        } while (begin <= end);
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        System.out.println(b);
    }
}
