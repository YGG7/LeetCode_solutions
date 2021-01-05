package LeetCode;

public class ClimbingStairs {
    private static int d = (int)1e9+7;

    // based on Fibonacci
    public int numWays(int n) {
        int f1=1, f2=1, fn=0;
        if (n==0||n==1) return 1;
        for (int i=2; i<=n;i++) {
            fn = (f1+f2)%d;
            f1=f2;
            f2=fn;
        }
        return fn;
    }
}
