package LeetCode;

import java.util.Stack;
import LeetCode.util.ListNode;

public class ReversePrintList {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode current = head;
        while (current!=null) {
            s.push(current.val);
            current = current.next;
        }

        // size() gets the current size of stack
        // be careful when calling size() in any dynamic space data structures
        // if unnecessary, do not call size() in the loop
        int size = s.size();
        int[] revArr = new int[size];
        for (int i=0;i<size;i++) {
            revArr[i] = s.pop();
        }
        return revArr;
    }
}
