package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyDivide {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        while (true) {
            String[] ip = br.readLine().split("/");
            int dividend = Integer.parseInt(ip[0]);
            int divisor = Integer.parseInt(ip[1]);
            System.out.printf("dividend, divisor: %d, %d\n", dividend, divisor);
            System.out.println("Result: "+divide(dividend, divisor));
        }
    }

    public static int divide(int dividend, int divisor) throws ArithmeticException {
        if (divisor == 0) throw new ArithmeticException();
        int d= divisor;
        int result = 1;
        while (d<dividend) {
            result<<=1;
            d<<=1;
        }
        while (d>dividend) {
            d -= divisor;
            result -= 1;
        }

        return result;
    }
}
