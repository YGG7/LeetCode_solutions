package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Jianzhi 48. Longest Substring Without Repeating Characters
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LongestNoRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;

        int len = s.length();
        int currMaxLen = 0;
        int left = -1;
        Map<Character, Integer> lastRepeat = new HashMap<>();
        char[] string = s.toCharArray();
        for (int i=0; i<len; i++) {
            if (lastRepeat.containsKey(string[i])) {
                left = Math.max(left, lastRepeat.get(string[i]));
            }
            lastRepeat.put(string[i], i);
            currMaxLen = Math.max(currMaxLen, i-left);
        }
        return currMaxLen;
    }
}
