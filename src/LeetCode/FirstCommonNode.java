package LeetCode;

import LeetCode.util.ListNode;

/**
 * Jianzhi 52. https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class FirstCommonNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        ListNode A = headA, B = headB;
        while (A!=B) {
            A = A==null?headB:A.next;
            B = B==null?headA:B.next;
        }
        return A;
    }
}
