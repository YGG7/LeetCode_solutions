package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class ContinuousSequenceSum {
    public int[][] findContinuousSequence(int target) {
        int start = 1, end = target/2+1;
        int i = start, j = start+1;
        List<int[]> res = new LinkedList<>();
        while (i<end && i<j) {
            int sum = continuousSum(i, j);
            if (sum==target) {
                res.add(getSequence(i, j));
                i++;
            }
            else if (sum<target) j++;
            else i++;
        }
        return res.toArray(new int[res.size()][]);
    }

    private int[] getSequence(int x, int y) {
        int len = y-x+1;
        int[] res = new int[len];
        for (int i=0; i<len; i++) {
            res[i] = i+x;
        }
        return res;
    }

    private int continuousSum(int x, int y) {
        return (x+y)*(y-x+1)/2;
    }
}
