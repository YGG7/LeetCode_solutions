package LeetCode;

/**
 * Jianzhi 53-II. https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums==null || nums.length==0) return -1;
        int len = nums.length;
        int i=0, j=len-1, m;
        while (i<=j) {
            m = i+(j-i)/2;
            if (nums[m]!=m) j = m-1;
            else i = m+1;
        }
        if (i<len) return nums[i]-1;
        else return nums[j]+1;
    }
}
