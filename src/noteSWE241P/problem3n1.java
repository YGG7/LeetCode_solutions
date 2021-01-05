// UVA Judge 100
package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem3n1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String input = "";
        //&&!input.trim().equals("\n") && !input.trim().equals("")
        while ((input = br.readLine()) != null) {
            int [] ip = new int[2];
            String[] ips = input.split(" ");
            ip[0] = Integer.parseInt(ips[0]);
            ip[1] = Integer.parseInt(ips[1]);
            int maxLen = maxCycleLength(ip[0], ip[1]);
            System.out.println(ip[0]+" "+ip[1]+" "+maxLen);
        }
    }

    public static int maxCycleLength(int start, int end) {
        int tmp = start;
        start = Math.min(start, end);
        end = Math.max(tmp, end);
        int maxL = 0;
        for (int j=start; j<=end; j++) {
            int L = 1;
            long i=j;
            while (i!=1) {
                if (i%2 == 1) {
                    i = 3*i+1;
                }
                else {
                    i = i/2;
                }
                L +=1;
            }
            maxL = Math.max(L, maxL);
        }
        return maxL;
    }
}
