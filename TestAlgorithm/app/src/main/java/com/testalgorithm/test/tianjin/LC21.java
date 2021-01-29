package com.testalgorithm.test.tianjin;


/**
 * Created by tianjin on 2021/1/29
 *
 * LeetCode- 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 */
class LC21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3.next != null){
            System.out.println("l3.val = " + l3.val);
            l3 = l3.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 注意：不是l1.next == null
        if (l1 == null) {
            // 注意：如果l1位null，就直接返回l2
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 取小的值
        if (l1.val < l2.val) {
            // 注意1：l1.next 说明了保留的第一个l1的值，从l1开始
            l1.next = mergeTwoLists(l1.next, l2);
            // 注意2：最后返回的就是从l1开始的
            return l1;
        } else {
            // 注意1：l2.next 说明了保留的第一个l2的值，从l2开始
            l2.next = mergeTwoLists(l1, l2.next);
            // 注意2：最后返回的就是从l2开始的
            return l2;
        }
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
