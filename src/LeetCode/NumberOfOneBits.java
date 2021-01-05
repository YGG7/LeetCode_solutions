package LeetCode;

/**
 * Jianzhi 15. https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0) {
            count += (n&1)==1?1:0;
            n = n>>>1; // unsigned right shift
        }
        return count;
    }

    // use n&(n-1) to eliminate the lowest 1 bit in n
    public int hammingWeight2(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
