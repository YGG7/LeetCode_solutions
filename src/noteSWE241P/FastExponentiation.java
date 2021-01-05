package noteSWE241P;

public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println(fastPower(5,10));
    }

    public static long fastPower(long a, long b) {
        long result =1;
        long base = a;
        while(b>0) {
            if ((b&1) == 1) {
                result = result*base;
            }
            b>>=1;
            base = base*base;
        }
        return result;
    }
}
