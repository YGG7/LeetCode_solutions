package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// poll priority implementation
public class TwoStackQueue2 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public TwoStackQueue2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(value);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int deleteHead() {
        if (s1.isEmpty()) return -1;
        return s1.pop();
    }
}
