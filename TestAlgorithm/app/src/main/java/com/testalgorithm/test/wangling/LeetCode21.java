package com.testalgorithm.test.wangling;

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

class LeetCode21 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = new ListNode();
        listNode.next.val = 2;
        listNode.next.next = new ListNode();
        listNode.next.next.val = 4;

        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode1.next = new ListNode();
        listNode1.next.val = 3;
        listNode1.next.next = new ListNode();
        listNode1.next.next.val = 4;


        mergeTwoLists(listNode, listNode1);

    }

    /**
     * 迭代思想解法 不需要新建ListNode 直接在原有链表上操作
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1){
            return l2;
        }else if (null == l2){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }


    }


    /**
     * 迭代思想解法 新建链表 比较后将数据存入新链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode listNode = new ListNode(-1);
        ListNode temp = listNode;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null? l2: l1;
        return listNode.next;
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
