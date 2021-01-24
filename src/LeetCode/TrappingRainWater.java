package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LC 42. https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    // brute solution
    public int trap(int[] height) {
        if (height==null || height.length==0) return 0;
        int len = height.length;
        int water = 0;
        for (int i=0; i<len; i++) {
            int curr_height = height[i];
            int max_left = 0, max_right = 0;
            // including curr_height itself
            for (int l=0; l<=i; l++) {
                max_left = Math.max(max_left, height[l]);
            }
            for (int r=i; r<len; r++) {
                max_right = Math.max(max_right, height[r]);
            }
            water += Math.min(max_left, max_right)-curr_height;
        }
        return water;
    }

    // use monotonic queue
    public int trap2(int[] height) {
        if (height==null || height.length==0) return 0;
        int len = height.length;
        int water = 0;
        Deque<Integer> monoqueue_right = new LinkedList<>();

        for (int i=0; i<len; i++) {
            while (!monoqueue_right.isEmpty() && monoqueue_right.getLast()<height[i]) {
                monoqueue_right.removeLast();
            }
            monoqueue_right.addLast(height[i]);
        }
        int max_left = 0, max_right = 0;
        for (int i=0; i<len; i++) {
            int curr_height = height[i];
            max_left = Math.max(max_left, curr_height);
            // monoqueue_right has at least one element
            max_right = monoqueue_right.getFirst();
            if (curr_height==max_right) monoqueue_right.removeFirst();
            water += Math.min(max_left, max_right)-curr_height;
        }
        return water;
    }

    // two-pointer
    public int trap3(int[] height) {
        if (height==null || height.length==0) return 0;
        int len = height.length;
        int water = 0;
        int left = 0, right = len-1;
        int max_left = height[0], max_right = height[len-1];
        while (left<right) {
            if (max_left<max_right) {
                water += max_left-height[left];
                left++;
                max_left = Math.max(max_left, height[left]);
            } else {
                water += max_right-height[right];
                right--;
                max_right = Math.max(max_right, height[right]);
            }
        }
        return water;
    }
}
