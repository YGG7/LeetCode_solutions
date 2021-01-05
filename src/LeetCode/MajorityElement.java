package LeetCode;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len==1) return nums[0];
        return nums[len/2];
    }
}
