package LeetCode;

/**
 * Jianzhi 64. https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class SumOfArithmeticSequence {
    public int sumNums(int n) {
        // use short circuiting to replace if
        boolean b = n>1 && (n+=sumNums(n-1))>0;
        return n;
    }
}
