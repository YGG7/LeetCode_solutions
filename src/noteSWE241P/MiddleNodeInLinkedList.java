package noteSWE241P;

import LeetCode.util.ListNode;

public class MiddleNodeInLinkedList {
    public ListNode findMiddleNode(ListNode head) {
        if (head==null) return null;
        ListNode curr = head, middle = head;
        while (curr!=null && curr.next!=null) {
            // cannot put the second logical judgement in the loop
            // it may lead to an endless loop
            curr = curr.next.next;
            middle = middle.next;
        }
        return middle;
    }
}
