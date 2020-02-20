package com.example.leetcode.question;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Question32
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/10  9:51
 */
public class Question32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        if (s == null || "".equals(s)) {
            return 0;
        }
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        int i = s.indexOf('(');
        if (i == -1) {
            return 0;
        }
        for (; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (!stack.empty() && stack.peek() == '(' ) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return s.length() - s.indexOf('(') - stack.size();
    }

    /*public static int longestValidParentheses(String s) {
        int len = 0;
        StringBuilder sbf = new StringBuilder();
        while (true) {
            sbf.append("()");
            if (s.indexOf(sbf.toString()) > -1) {
                len += 2;
            } else {
                break;
            }
        }
        return len;
    }*/
}
