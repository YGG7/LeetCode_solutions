package LeetCode;

import LeetCode.util.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode fakeHead = result;

        while (l1!=null || l2!=null) {
            if (l2==null) {
                result.next = l1;
                l1 = l1.next;
            }
            else if (l1==null) {
                result.next = l2;
                l2 = l2.next;
            }
            else {
                if (l1.val<l2.val) {
                    result.next = l1;
                    l1 = l1.next;
                } else {
                    result.next = l2;
                    l2 = l2.next;
                }
            }
            result = result.next;
        }
        return fakeHead.next;
    }
}
