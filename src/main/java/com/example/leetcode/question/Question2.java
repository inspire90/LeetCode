package com.example.leetcode.question;

import com.example.leetcode.entity.ListNode;

/**
 * Question2
 *
 * @author shentao
 * @date 2020/2/19
 */
public class Question2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = carry(false, l1, l2);
        return result;
    }

    private static ListNode carry(boolean flag, ListNode l1, ListNode l2) {
        ListNode result = null;
        if (l1 != null || l2 != null) {
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (flag) {
                val++;
            }
            if (val >= 10) {
                result = new ListNode(val - 10);
                result.next = carry(true, l1 != null ? l1.next : null, l2 != null ? l2.next : null);
            } else {
                result = new ListNode(val);
                result.next = carry(false, l1 != null ? l1.next : null, l2 != null ? l2.next : null);
            }
        } else if (flag) {
            result = new ListNode(1);
            result.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(8);
        ListNode l2 = new ListNode(0);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
