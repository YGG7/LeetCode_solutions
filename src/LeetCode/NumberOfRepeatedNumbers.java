package LeetCode;

/**
 * Jianzhi 53-I https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class NumberOfRepeatedNumbers {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int i = 0, j = len - 1, m = 0, left = 0, right = 0;

        // search left point
        while (i <= j) {
            m = i + (j - i) / 2;
            if (nums[m] >= target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        if (i < len && nums[i] != target) return 0;
        left = i;
        i = 0;
        j = len - 1;

        // search right point
        while (i <= j) {
            m = i + (j - i) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        right = j;
        return right - left + 1;
    }
}
