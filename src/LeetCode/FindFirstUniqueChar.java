package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Jianzhi 50. https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FindFirstUniqueChar {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        // LinkedHashMap can be iterated by the same order as
        // the order that you put the items in
        LinkedHashMap<Character, Boolean> dict = new LinkedHashMap<>();
        for (char c:chars) {
            if (dict.containsKey(c)) {
                dict.put(c, false);
            }
            else { // unique character
                dict.put(c, true);
            }
        }
        for (Map.Entry<Character, Boolean> entry:dict.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
