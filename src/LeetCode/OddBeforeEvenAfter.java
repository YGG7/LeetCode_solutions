package LeetCode;

/**
 * Jianzhi 21. https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class OddBeforeEvenAfter {
    public int[] exchange(int[] nums) {
        int idxL = 0, idxR = nums.length-1;
        while (idxL<idxR) {
            boolean isLeftOdd = isOdd(nums[idxL]), isRightOdd = isOdd(nums[idxR]);
            if(!isLeftOdd && isRightOdd) {
                swap(nums, idxL, idxR);
                idxL++;
                idxR--;
            } else if(isLeftOdd && isRightOdd) {
                idxL++;
            } else if(!isLeftOdd && !isRightOdd) {
                idxR--;
            } else {
                idxL++;
                idxR--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean isOdd(int num) {
        return (num&1)==1;
    }
}
