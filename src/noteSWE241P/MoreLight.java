package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoreLight {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = "";
        while ((line=br.readLine())!=null) {
            long n = Long.parseLong(line.trim());
            if (n==0) break;
            long sqrt = (int)Math.sqrt(n);
            if (sqrt*sqrt == n) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
