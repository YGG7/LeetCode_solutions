package LeetCode;

import java.util.Arrays;

/**
 * Jianzhi 58-I. https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class ReverseWordSequence {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] words = s.trim().split(" ");
        for (int i=words.length-1; i>=0; i--) {
            if (words[i].equals("")) continue;
            builder.append(words[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String s = " hello  world ";
        System.out.println(Arrays.toString(s.split(" "))+s.split(" ").length);
        System.out.println(Arrays.toString(s.trim().split("\\s+"))+s.split("\\s+").length);
    }
}
