// https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
// 04/07/2020

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CutRope {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int len = Integer.parseInt(br.readLine());
        System.out.printf("length of rope = %d\n", len);
        System.out.printf("result of cut rope: %d",cutRope(len));
    }

    public static int cutRope(int len) {
        if (len <= 1) return 0;
        if (len == 2) return 1;
        if (len == 3) return 2;
        int remainder = len%3;
        int index = len/3;
        if (remainder == 0) return (int)Math.pow(3, index);
        if (remainder == 1) return (int)Math.pow(3, index-1)*4;
        return (int)Math.pow(3, index)*2;
    }
}
