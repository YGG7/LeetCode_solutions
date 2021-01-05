package LeetCode;

/**
 * Jianzhi 56-II. https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if (nums==null) return 0;
        int res = 0;
        for (int i=0; i<32; i++) {
            int tmp = 1 << i;
            int oneBitCount = 0;
            // get the number of one bits in array on the current bit
            for (int num:nums) {
                if ((num&tmp) != 0) oneBitCount++;
            }
            // using oneBitCount%3 != 0 is also ok
            if (oneBitCount%3 == 1) res |= tmp;
        }
        return res;
    }
}
