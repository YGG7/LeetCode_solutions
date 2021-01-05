package LeetCode;

public class NumberOfDigitOne {
    private int[] mem;

    public int countDigitOne(int n) {
        String num = Integer.toString(n);
        int digits = num.length();
        // to record number of digit one of every (pow-1)
        // such as count(0), count(9), count(99), ...
        mem = new int[digits+1];
        mem[0] = 0;
        for (int i=1; i<digits+1; i++) {
            mem[i] = 10*mem[i-1]+(int) Math.pow(10, i-1);
        }

        return recurCount(n);
    }

    private int recurCount(int n) {
        if (n<=0) return 0;

        String num = Integer.toString(n);
        int len = num.length();
        int highest = num.charAt(0)-'0';
        int pow = (int) Math.pow(10, len-1);
        int rest = n-highest*pow;
        if (highest==1) {
//            return recurCount(pow-1)+rest+1+recurCount(rest);
            return mem[len-1]+rest+1+recurCount(rest);
        }
        else {
//            return highest*recurCount(pow-1)+pow+recurCount(rest);
            return highest*mem[len-1]+pow+recurCount(rest);
        }
    }
}
