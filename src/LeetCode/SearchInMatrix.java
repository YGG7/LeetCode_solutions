package LeetCode;

public class SearchInMatrix {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // statement says 0<=n<=100, 0<=m<=1000
        // needs extra check
        int n=matrix.length;
        if (n==0) return false;
        int m=matrix[0].length;
        if (m==0) return false;

        int i=n-1, j=0;
        while(i>=0&&j<m) {
            if(matrix[i][j]==target) {
                return true;
            } else if (matrix[i][j]>target) {
                i-=1;
            } else {
                j+=1;
            }
        }
        return false;
    }
}
