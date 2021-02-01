package com.testalgorithm.test.hubingfeng;

public class LeetCodeNo21 {

    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-100);
        ListNode prev = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1 = l1.next;
                prev.next = l1;
            } else {
                l2 = l2.next;
                prev.next = l2;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return root.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode();
        if (l1.val < l2.val) {
            root.val = l1.val;
            root.next = mergeTwoLists(l1.next, l2);
        } else {
            root.val = l2.val;
            root.next = mergeTwoLists(l1, l2.next);
        }
        return root;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
