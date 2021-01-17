package LeetCode;

import java.util.Arrays;

/**
 * Jianzhi 61. https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class PokerStraight {
    public boolean isStraight(int[] nums) {
        if (nums==null || nums.length==0) return false;
        int len = nums.length;
        int index_min = 0;
        Arrays.sort(nums);
        for (int i=0; i<len-1; i++) {
            if (nums[i]==0) index_min++;
            else if (nums[i]==nums[i+1]) return false;
        }
        return nums[len-1]-nums[index_min]<len;
    }
}
