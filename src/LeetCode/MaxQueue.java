package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Jianzhi 59-II. https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.getLast()<value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int e = queue.poll();
        if (e == deque.getFirst()) deque.removeFirst();
        return e;
    }
}
