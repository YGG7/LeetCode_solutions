package LeetCode;

/**
 * Jianzhi 16. https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;
        long power = (n>=0)?n:-(long)n;
        double base = (n>=0)?x:1/x;
        double result = 1.0;
        while (power>0) {
            if((power&1)==1) result*=base;
            power>>=1;
            base = base*base;
        }
        return result;
    }
}
