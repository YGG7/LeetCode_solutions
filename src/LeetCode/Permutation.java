package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public String[] permutation(String s) {
        List<String> res = new LinkedList<>();
        dfs(res, s.toCharArray(), 0);
        return res.toArray(new String[0]);
    }

    private void dfs(List<String> res, char[] chars, int x) {
        if (x==chars.length-1) {
            res.add(new String(chars));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i=x; i<chars.length;i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(chars, x, i);
            dfs(res, chars, x+1);
            swap(chars, x, i);
        }
    }

    private void swap(char[] chars, int x, int y) {
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

}
