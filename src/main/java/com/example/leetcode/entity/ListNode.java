package com.example.leetcode.entity;

/**
 * ListNode
 *
 * @author shentao
 * @date 2020/2/19
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode add(int v) {
        ListNode l = new ListNode(v);
        this.next = l;
        return l;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
