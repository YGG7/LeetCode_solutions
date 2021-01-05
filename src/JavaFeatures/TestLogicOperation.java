package JavaFeatures;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class TestLogicOperation {
    public static void main(String[] args) {
        int i = 10;
//        String i_b = Integer.toBinaryString(i);
//        System.out.println(i_b);
//        System.out.println(Integer.parseUnsignedInt(i_b, 2));
//        System.out.println(Integer.parseInt("1111", 2));
//        System.out.println(Integer.toBinaryString(i&15));
//        int pos = 1;
//        for (i=10; i>=0; i--) {
//            int newpos = pos |(1<<i);
//            System.out.println(newpos);
//        }

//        int n = Integer.parseInt("100101", 2);
//        int m = (1<<4);
//        System.out.println(n);
//        System.out.println(Integer.toBinaryString(m));
//        System.out.println(n&m);
//        System.out.println(Integer.toBinaryString(n&m));

        int[] test = {1,2,3,4,5,6,7,8,9,10};
        int[] parents = new int[test.length];
        int[] leftchidren = new int[test.length];
        System.out.println(Arrays.toString(test));

        for (int j=0; j<test.length; j++) {
            parents[j] = getParentIndex(test[j]);
        }
        System.out.println(Arrays.toString(parents));

        for (int j=0; j<test.length; j++) {
            leftchidren[j] = getLeftChildIndex(test[j]);
        }
        System.out.println(Arrays.toString(leftchidren));
    }

    private static int getLeftChildIndex(int index) {
        if (index<0) return -1;
        return (index<<1)+1;
    }

    private static int getParentIndex(int index) {
        if (index<=0) return -1;
        return (index-1)>>1;
    }
}
