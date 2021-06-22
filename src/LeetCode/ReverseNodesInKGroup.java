package LeetCode;

import LeetCode.util.ListNode;

import java.util.List;

/**
 * LC 25. https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k==1) return head;
        int len = listLength(head);
        ListNode prev = null, curr = head;
        ListNode fakeHead = new ListNode(0);
        // store the last group tail to avoid overwriting
        ListNode groupHead = null, groupLastTail = fakeHead, groupTail = null; // head and tail of reversed group
        for (int i = 0; i < (len / k) * k; i++) {
            ListNode tmp = curr.next;
            if (i % k == 0) {
                groupTail = curr;
                prev = curr;
                curr = tmp;
            } else if (i % k == k - 1) {
                groupHead = curr;
                groupLastTail.next = groupHead;
                groupLastTail = groupTail;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            } else {
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
        }
        if (groupTail != null) groupTail.next = curr;
        return fakeHead.next;
    }

    private static int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode lastGroupTail = fakeHead;
        while (curr != null) {
            ListNode tmpHead = curr;
            for (int i=1; i<k; i++) {
                curr = curr.next;
                if (curr == null) {
                    lastGroupTail.next = tmpHead;
                    return fakeHead.next;
                }
            }
            ListNode next = curr.next;
            ListNode[] reversedGroupHT = reverse(tmpHead, curr, lastGroupTail);
            lastGroupTail = reversedGroupHT[1];
            curr = next;
        }
        return fakeHead.next;
    }

    private static ListNode[] reverse(ListNode head, ListNode tail, ListNode lastGroupTail) {
        ListNode prev = null, curr = head;
        while (prev != tail) {
            ListNode tmp = curr.next;
            if (curr == tail) {
                lastGroupTail.next = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // return the reversed group head and tail
        return new ListNode[]{tail, head};
    }

    private static ListNode reverse2(ListNode head, ListNode tail, ListNode lastGroupTail) {
        ListNode prev = null, curr = head;
        while (prev != tail) {
            ListNode tmp = curr.next;
            if (curr == tail) {
                lastGroupTail.next = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // return the reversed group head and tail
        return head;
    }

    // reverseKGroup keeps the original order of remaining nodes that are not enough to form a K-group
    // reverseKGroupAlt also reverses the order of these nodes
    public static ListNode reverseKGroupAlt(ListNode head, int k) {
        if (head == null) return null;
        if (k==1) return head;
        int count = 0;
        ListNode prev = null, curr = head;
        ListNode fakeHead = new ListNode(0);
        // store the last group tail to avoid overwriting
        ListNode groupHead = null, groupLastTail = fakeHead, groupTail = null; // head and tail of reversed group

        while (curr != null){
            ListNode tmp = curr.next;
            if (count == 0) {
                groupTail = curr;
                prev = curr;
                curr = tmp;
                count++;
            } else if (count == k - 1) {
                groupHead = curr;
                groupLastTail.next = groupHead;
                groupLastTail = groupTail;
                curr.next = prev;
                prev = curr;
                curr = tmp;
                count = 0;
            } else {
                curr.next = prev;
                prev = curr;
                curr = tmp;
                count++;
            }
        }
        groupTail.next = groupHead;
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i=2; i<15; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        curr = head;
        for (int i=1; i<15; i++) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();

//        ListNode reversedHead = reverseKGroup(head, 3);
        ListNode reversedHead = reverseKGroupAlt(head, 4);
        curr = reversedHead;
        for (int i=1; i<15; i++) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
}
