package JavaFeatures;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class TestInteger {
    public static void main(String[] args) {
        System.out.println("MAX_VALUE: "+Integer.MAX_VALUE);
        System.out.println("MIN_VALUE: "+Integer.MIN_VALUE);
        long tmp = Integer.MIN_VALUE;
        tmp--;
        long tmp2 = Integer.MIN_VALUE-1;
        System.out.println(Integer.MIN_VALUE-1);
        System.out.println(tmp);
        System.out.println(tmp2);
    }
}
