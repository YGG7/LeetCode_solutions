package LeetCode;

import LeetCode.util.ListNode;

/**
 * LC 206. https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode prev = null, curr = head;
        while (curr!=null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
