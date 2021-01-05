package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimaryArithmetic {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = "";
        while ((line=br.readLine())!=null) {
            line = line.trim();
            if (line.equals("0 0")) break;

            String[] nums = line.split(" ");
            if (nums.length!=2) {
                System.out.println("input format error");
                break;
            }

            int n1l = nums[0].length(), n2l = nums[1].length();
            int[] num1 = new int[n1l];
            int[] num2 = new int[n2l];
            int[] longNum = n1l>=n2l?num1:num2;
            for (int i=n1l-1;i>=0;i--) {
                num1[n1l-1-i] = Character.getNumericValue(nums[0].charAt(i));
            }
            for (int i=n2l-1;i>=0;i--) {
                num2[n2l-1-i] = Character.getNumericValue(nums[1].charAt(i));
            }

            int carry = 0, carryCount = 0;
            int i=0;
            while (i<Math.min(n1l,n2l)) {
                carry = (carry+num1[i]+num2[i])/10;
                carryCount += carry>0?1:0;
                i++;
            }

            while (carry>0&&i<Math.max(n1l,n2l)) {
                carry = (carry+longNum[i])/10;
                carryCount += carry>0?1:0;
                i++;
            }

            if (carryCount > 1) {
                System.out.printf("%d carry operations.\n", carryCount);
            } else if (carryCount == 1) {
                System.out.printf("%d carry operation.\n", carryCount);
            } else {
                System.out.println("No carry operation.");
            }

        }

    }

}
