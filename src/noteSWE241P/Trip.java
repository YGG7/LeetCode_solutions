// UVA Judge 10137
package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Trip {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(is);
        String numS = "";
        while ((numS = rd.readLine()) != null) {
            int num = Integer.parseInt(numS.trim());
            if (num==0) break;

            int[] expenses = new int[num];
            int all = 0, ave =0, ave_more=0, result=0;
            for (int i=0; i<num; i++) {
                String[] bits = rd.readLine().split("\\.");
                int front = Integer.parseInt(bits[0]);
                int back = Integer.parseInt(bits[1].replaceFirst("^0+(?!$)", "").trim());
                expenses[i] = 100*front+back;
                all += expenses[i];
            }
//            System.out.println(Arrays.toString(expenses));
            ave = all/num;
            ave_more = all%num==0?ave:ave+1;
            for (int i=0; i<num; i++) {
                int exchange = ave_more-expenses[i];
                if (expenses[i]<ave_more) {
                    result += exchange;
                }
            }

            System.out.printf("$%d.%02d\n", result/100, result%100);
        }
    }

}
