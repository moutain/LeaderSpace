package com.testalgorithm.test.hubingfeng;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/
 */
class LeetCodeNo160 {

    public static void main(String[] args) {
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lA = headA;
        ListNode lB = headB;
        while (lA != lB) {
            if (lA == null) {
                lA = headB;
            }else{
                lA = lA.next;
            }
            if (lB == null) {
                lB = headA;
            }else{
                lB = lB.next;
            }
        }
        return lA;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



}
