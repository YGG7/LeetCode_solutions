package LeetCode;

import java.util.Stack;

// offer priority implementation
public class TwoStackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public TwoStackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty()) return -1;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int head = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return head;
    }
}
