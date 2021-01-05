package LeetCode;

/**
 * Jianzhi 47. https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxSumPath {
    public int maxValue(int[][] grid) {
        if (grid==null || grid.length<1) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0&&j==0) continue;
                else if (i==0) grid[i][j] += grid[i][j-1];
                else if (j==0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

//    private int dfs(int[][] grid, int i, int j, int m, int n) {
//        if (i>=m || j>=n) return Integer.MIN_VALUE;
//        if (i==m-1 && j==n-1) return grid[i][j];
//        int sum1 = dfs(grid, i+1, j, m, n);
//        int sum2 = dfs(grid, i, j+1, m, n);
//        return Math.max(sum1, sum2)+grid[i][j];
//    }
}
