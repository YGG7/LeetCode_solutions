import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RangeOfRobot {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String[] input = br.readLine().split(" ");
        int[] arg = new int[input.length];
        for (int i=0; i<input.length; i++) {
            arg[i] = Integer.parseInt(input[i]);
//            System.out.println(arg[i]);
        }
        System.out.println(bitSum(arg[0], arg[1]));
    }

    private static int bitSum(int n1, int n2) {
        int sum1=0, sum2=0;
        while(n1>0) {
            sum1 += n1%10;
            n1 /= 10;
        }
        while(n2>0) {
            sum2 += n2%10;
            n2 /= 10;
        }
        return sum1+sum2;
    }
}
