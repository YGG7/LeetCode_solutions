package LeetCode;

public class Fibonacci {
    static int d = (int)1e9+7;
    public int fib(int n) {
        if (n>1) {
            int fib=0, p1=1,p2=0;
            for (int i=2;i<=n;i++) {
                fib = (p1+p2)%d;
                p2 = p1;
                p1 = fib;
            }
            return fib;
        } else if (n==1) {
            return 1;
        } else  {
            return 0;
        }
    }

}
