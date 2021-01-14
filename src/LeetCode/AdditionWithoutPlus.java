package LeetCode;

/**
 * Jianzhi 65. https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */

public class AdditionWithoutPlus {
    public int add(int a, int b) {
        int res = a^b;
        int carry = (a&b)<<1;
        while(carry!=0) {
            int tmp = (res&carry)<<1;
            res ^= carry;
            carry = tmp;
        }
        return res;
    }
}
