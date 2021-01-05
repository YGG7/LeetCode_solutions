package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Jianzhi 45. https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class SmallestNumberOrder {
    public String minNumber(int[] nums) {
        if (nums==null) return null;
        int len = nums.length;
        String[] stringNums = new String[len];
        for (int i=0; i<len; i++) {
            stringNums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<len; i++) {
            builder.append(stringNums[i]);
        }
        return builder.toString();
    }
}
