package com.testalgorithm.test.tianjin;


/**
 * Created by tianjin on 2021/2/9
 * 160. 相交链表 和面试题 02.07. 链表相交一样的
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/
 */
class LC160 {

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     * @param headA
     * @param headB
     * @return
     */
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

    public static void main(String[] args) {
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(1);
//        list1.next.next.next = new ListNode(3);

        ListNode list2 = new ListNode(6);
        list2.next = new ListNode(5);
//        list2.next.next = new ListNode(1);
//        list2.next.next.next = new ListNode(3);

        // 上面的list1（4，2，1，3），list2（6，5，1，3）是不会相交的，虽然后面1，3是相同的，
        // 但是不是同一个地址的换个写法

        ListNode commNode = new ListNode(1);
        commNode.next = new ListNode(3);

        list1.next.next = commNode;
        list2.next.next = commNode;

        ListNode list3 = getIntersectionNode(list1, list2);
        System.out.println("l3.val="+ list3.val);

    }


}
