package LeetCode;

/**
 * Jianzhi 42. Max Sub-Array Sum https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArraySum {
    public int maxSubArraySum(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int len = nums.length;
        int endWithCurr = 0, endWithLast = nums[0];
        int maxSum = nums[0];
        for(int i=1; i<len; i++) {
            endWithCurr = nums[i]+Math.max(0, endWithLast);
            endWithLast = endWithCurr;
            maxSum = Math.max(maxSum, endWithCurr);
        }
        return maxSum;
    }
}
