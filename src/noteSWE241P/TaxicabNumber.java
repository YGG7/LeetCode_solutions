package noteSWE241P;

import sun.nio.cs.ext.MacThai;

import java.util.ArrayList;
import java.util.Arrays;

public class TaxicabNumber {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findTaxicabNumber(10000).toArray()));
        findTaxicabNumber(100000);
    }

    public static ArrayList<Integer> findTaxicabNumber(int bound) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=1;i<=bound;i++) {
            int element_bound = (int)Math.cbrt(i);
            int l=0, r=element_bound;
            int count = 0;
            while (l<r) {
                int sum = l*l*l + r*r*r;
                if (sum < i) {
                    l+=1;
                }
                else if (sum>i) {
                    r-=1;
                }
                else {
                    l+=1;
                    r-=1;
                    count+=1;
                    if (count>=2) {
                        System.out.printf("taxicab number: %d\n", i);
                        result.add(i);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
