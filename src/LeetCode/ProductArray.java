package LeetCode;

/**
 * Jianzhi 66. https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class ProductArray {
    public int[] constructArr(int[] a) {
        if (a==null || a.length==0) return new int[0];
        int len = a.length;
        int[] m1 = new int[len];
        int[] m2 = new int[len];
        int[] res = new int[len];
        m1[0] = 1;
        m2[len-1] = 1;
        for (int i=1; i<len; i++) {
            m1[i] = m1[i-1] * a[i-1];
            m2[len-1-i] = m2[len-i] * a[len-i];
        }
        for (int i=0; i<len; i++) {
            res[i] = m1[i] * m2[i];
        }
        return res;
    }
}
