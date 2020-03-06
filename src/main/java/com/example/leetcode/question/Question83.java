package com.example.leetcode.question;

import com.example.leetcode.entity.ListNode;

/**
 * Question83
 *
 * @author shentao
 * @date 2020/2/23
 */
public class Question83 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(1).add(2).add(3).add(3);
        ListNode listNode1 = deleteDuplicates(listNode);
        System.out.println(listNode1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }
}
