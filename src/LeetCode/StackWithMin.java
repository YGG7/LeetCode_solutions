package LeetCode;

import java.util.Stack;

/**
 * Jianzhi 30. https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class StackWithMin {
    private Stack<Integer> mains, mins;
    public StackWithMin() {
        mains = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        mains.push(x);
        if(mins.empty() || x<=mins.peek()) mins.push(x);
    }

    public void pop() {
        if(mains.pop() <= mins.peek()) mins.pop();
    }

    public int top() {
        return mains.peek();
    }

    public int min() {
        return mins.peek();
    }
}
