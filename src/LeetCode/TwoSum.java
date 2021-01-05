package LeetCode;

public class TwoSum {
    public int[] getTwoSum(int[] nums, int target) {
        if (nums==null || nums.length<2) return null;
        int left = 0, right = nums.length-1;
        while (left<right) {
            int i = nums[left], j = nums[right];
            if (i+j==target) {
                return new int[]{i,j};
            }
            else if (i+j<target) {
                left++;
            }
            else {
                right--;
            }
        }
        return null;
    }
}
