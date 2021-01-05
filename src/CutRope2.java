// https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
// 04/07/2020

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CutRope2 {
    private static int mod = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("please enter the length of rope");
        int len = Integer.parseInt(br.readLine());
        System.out.printf("length of rope = %d\n", len);
        System.out.printf("result of cut rope2: %d\n",cutRope2(len));
        System.out.printf("result of cut rope2fast: %d\n",cutRope2Fast(len));
    }

    public static int cutRope2(int len) {
        if (len <= 1) return 0;
        if (len == 2) return 1;
        if (len == 3) return 2;
        int remainder = len%3;
        int index = len/3;
        if (remainder == 0) return (int)(pow_circle(3, index)%mod);
        if (remainder == 1) return (int)((pow_circle(3, index-1)*4)%mod);
        return (int)((pow_circle(3, index)*2)%mod);
    }

    public static int cutRope2Fast(int len) {
        if (len <= 1) return 0;
        if (len == 2) return 1;
        if (len == 3) return 2;
        int remainder = len%3;
        int index = len/3;
        if (remainder == 0) return (int)(pow_fast(3, index)%mod);
        if (remainder == 1) return (int)((pow_fast(3, index-1)*4)%mod);
        return (int)((pow_fast(3, index)*2)%mod);
    }

    private static long pow_circle(int base, int index) {
        long rem = 1;
        for (int i=0;i<index;i++) {
            rem = (rem*base)%mod;
        }
        return rem;
    }

    private static long pow_fast(int base, int index) {
        long rem = 1;
        long b = base;
        while (index > 0) {
            if((index&1)==1) rem = (rem * b)%mod;
            b = (b*b)%mod;
            index >>=1;
        }
        return rem;
    }

}
