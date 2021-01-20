package LeetCode;

/**
 * LC 5. https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return null;
        int len = s.length();
        char[] s_array = s.toCharArray();
        int left=0, right=0, maxlen=0;
        // dp[i][j] is true when substring from position i to j is palindromic
        boolean[][] dp = new boolean[len][len];
        for (int l=1; l<=len; l++) {
            for (int i=0; i+l<=len; i++) {
                int j = i+l-1;
                if (l==1) dp[i][j] = true;
                else if (l==2 && s_array[i]==s_array[j]) dp[i][j] = true;
                else if (dp[i+1][j-1] && s_array[i]==s_array[j]) dp[i][j] = true;
                if (maxlen<l && dp[i][j]) {
                    maxlen = l;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}
