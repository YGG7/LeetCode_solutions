package LeetCode;

import LeetCode.util.ListNode;

/**
 * Jianzhi 22. https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class LastKNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode aim = head;
        ListNode curr = head;
        int count = 0;
        while (curr.next!=null) {
            curr = curr.next;
            if (count<k-1) {
                count++;
            } else {
                aim = aim.next;
            }
        }
        return aim;
    }
}
