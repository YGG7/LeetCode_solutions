package JavaFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class TestString {
    public static void main(String[] args) {
        String s ="Posting Date: August 26, 2008 [EBook #1342]_your_";
        System.out.println(Arrays.toString(s.split("\\W+")));
        ArrayList<Integer> ar = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        Date date = new Date();
        System.out.println(date.toString().replaceAll("[ :]", "_"));
    }
}
