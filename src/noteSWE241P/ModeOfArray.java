package noteSWE241P;

import java.util.HashMap;

/**
 * The Algorithm Design Manual Exercise 4-5
 */
public class ModeOfArray {
    public static int getMode(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxE=0, maxFreq=Integer.MIN_VALUE;
        for (int i:arr) {
            if (hashMap.containsKey(i)) hashMap.put(i, hashMap.get(i)+1);
            else hashMap.put(i, 1);
        }
        // iterate the hash map to find the element with max frequency
        for (HashMap.Entry<Integer, Integer> e:hashMap.entrySet()) {
            if (e.getValue()>maxFreq) {
                maxE = e.getKey();
                maxFreq = e.getValue();
            }
        }
        return maxE;
    }

    public static void main(String[] args) {
        int[] test = {4,6,2,5,4,1,1,2,4};
        System.out.println(getMode(test));
    }
}
