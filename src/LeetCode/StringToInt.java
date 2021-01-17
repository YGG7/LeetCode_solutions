package LeetCode;

/**
 * Jianzhi 67. https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */
public class StringToInt {
    public int strToInt(String str) {
        char[] s_array = str.trim().toCharArray();
        int len = s_array.length;
        if (len==0) return 0;

        int sign = 0;
        int val = 0;
        int start = 0;
        int bound = Integer.MAX_VALUE/10;
        char c0 = s_array[0];

        if (c0=='-') {
            sign=1;
            start=1;
        } else if (c0=='+') {
            start=1;
        }

        for (int i=start; i<len; i++) {
            char c = s_array[i];
            if (c>'9' || c<'0') break;
            if (val>bound || (val==bound && c>'7')) return sign==0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            val = val*10 + (c-'0');

        }
        return sign==0?val:-val;
    }
}
