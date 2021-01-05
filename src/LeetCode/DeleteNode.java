package LeetCode;

import LeetCode.util.ListNode;

/**
 * Jianzhi 18. https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return null;
        ListNode curr = head, pre = null;
        while(curr!=null) {
            if(curr.val==val) break;
            pre = curr;
            curr = curr.next;
        }

        if(curr==null) return null; // search failed
        else if(curr==head) return curr.next;
        else {
            pre.next = curr.next;
            return head;
        }
    }
}
