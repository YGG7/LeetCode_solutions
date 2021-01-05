package LeetCode;

/**
 * Jianzhi 56-I https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class TwoSingleNumber {
    public int[] singleNumbers(int[] nums) {
        if (nums==null) return null;
        int k = 0;
        for (int num:nums) {
            k ^= num;
        }

        int mask  = 1;
        while ((mask&k) == 0) {
            mask <<= 1;
        }

        int a=0, b=0;
        for (int num:nums) {
            if ((num&mask)==0) {
                a^=num;
            }
            else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
