package LeetCode;

import LeetCode.util.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = head, curr = head.next;
        if(curr==null) return head;

        pre.next = null;
        while (curr!=null) {
            // store the next node
            // otherwise we will lost it
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
