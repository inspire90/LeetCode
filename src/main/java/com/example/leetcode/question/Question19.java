package com.example.leetcode.question;

import com.example.leetcode.entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Question19
 *
 * @author shentao
 * @date 2020/2/23
 */
public class Question19 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2).add(3).add(4).add(5);
        ListNode end = removeNthFromEnd(listNode, 2);
        System.out.println(end);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        dummy.next = head;
        int len = 0;
        while (first.next != null) {
            len++;
            first = first.next;
        }
        first = dummy;
        len = len - n;
        while (len >= 0) {
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

}
