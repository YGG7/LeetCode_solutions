package LeetCode;

import java.util.Arrays;

/**
 * Jianzhi 13. https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class MovingRange {
    private int numBlock;
    private int numRows;
    private int numColumns;
    public int movingCount(int m, int n, int k) {
        boolean[][] matrix = new boolean[m][n];
        numBlock = 0;
        numRows = m;
        numColumns = n;
        for(boolean[] line:matrix) {
            Arrays.fill(line, false);
        }
        dfs(matrix,0,0,k);
        return numBlock;
    }

    private void dfs(boolean[][] m, int i, int j, int k) {
        if (isInArea(i, j) && digitSum(i, j)<=k && !m[i][j]) {
            numBlock+=1;
            m[i][j] = true;
            dfs(m, i, j+1, k);
            dfs(m, i+1, j, k);
        }
    }

    private boolean isInArea(int x, int y) {
        return x>=0 && x<numRows && y>=0 && y<numColumns;
    }

    private int digitSum(int x, int y) {
        int sum = 0;
        while(x!=0) {
            sum+= x%10;
            x = x/10;
        }
        while(y!=0) {
            sum+= y%10;
            y = y/10;
        }
        return sum;
    }
}
