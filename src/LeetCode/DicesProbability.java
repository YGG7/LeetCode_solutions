package LeetCode;

/**
 * Jianzhi 60. https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class DicesProbability {
    public double[] dicesProbability(int n) {
        if (n<=0) return new double[0];
        double[] res = new double[5*n+1];
        double[][] dp = new double[n+1][6*n+1];
        for (int j=1; j<=6; j++) {
            dp[1][j] = 1/6d;
        }
        for (int i=2; i<=n; i++) {
            for (int j=i; j<=6*i; j++) {
                for (int k=1; k<=6; k++) {
                    if (j>k) dp[i][j] += dp[i-1][j-k]*1/6d;
                }
            }
        }
        for (int i=0; i<5*n+1; i++) {
            res[i] = dp[n][i+n];
        }
        return res;
    }
}
