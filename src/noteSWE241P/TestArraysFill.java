package noteSWE241P;

import java.util.Arrays;

public class TestArraysFill {
    public static void main(String[] args) {
        int[] a = new int[10];
        Arrays.fill(a, 7);
        System.out.println(Arrays.toString(a));
    }
}
