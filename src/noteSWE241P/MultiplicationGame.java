package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationGame {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = "";
        while((line = br.readLine())!=null) {
            int n = Integer.parseInt(line.trim());
            // round up
            int victoryKey = n;
            while (victoryKey>18) {
                victoryKey = (int)Math.ceil((double)victoryKey/18);
            }
            if (victoryKey<=9&&victoryKey>0) {
                System.out.println("Stan wins.");
            } else {
                System.out.println("Ollie wins.");
            }
        }
    }
}
