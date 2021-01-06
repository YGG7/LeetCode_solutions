package LeetCode;

/**
 * Jianzhi 58-II. https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class LeftReverseString {
    public String reverseLeftWords(String s, int n) {
        if (s==null || s.length()==0) return s;
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i=n; i<n+len; i++) {
            builder.append(s.charAt(i%len));
        }
        return builder.toString();
    }
}
