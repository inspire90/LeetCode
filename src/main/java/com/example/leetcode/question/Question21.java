package com.example.leetcode.question;

import com.example.leetcode.entity.ListNode;

/**
 * Question21
 *
 * @author shentao
 * @date 2020/2/20
 */
public class Question21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = carry(l1, l2);
        while (l1 != null && l2 != null) {
            listNode.next = carry(l1.next, l2.next);
            listNode = listNode.next;
        }
        return listNode;
    }

    public static ListNode carry(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode temp = listNode;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 <= val2) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2).add(4);
        ListNode l2 = new ListNode(1);
        l2.add(3).add(4);
        ListNode node = carry(l1, l2);
        System.out.println(node);
    }
}
