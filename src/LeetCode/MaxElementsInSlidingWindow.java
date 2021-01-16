package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Jianzhi 59-I https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxElementsInSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || k>nums.length || k<=0) return new int[0];
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<k; i++) {
            while (!deque.isEmpty() && nums[i]>deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.getFirst();
        for (int i=k; i<len; i++) {
            int j = i-k;
            if (!deque.isEmpty() && deque.getFirst()==nums[j]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i]>deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[j+1] = deque.getFirst();
        }
        return res;
    }
}
