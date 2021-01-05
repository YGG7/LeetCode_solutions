import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nums = line.trim().split(" ");
        double[] numbers = {
                3.5,
                3.5, 3.5, 4.0,
                4.0, 4.0, 3.5, 3.7, 4.0, 4.0, 3.9, 3.6,
                4.0, 4.0, 4.0, 4.0, 4.0
        };
        int sum = 0;
        double gpa = 0.0;
        for (int i=0;i<nums.length;i++) {
            sum += Integer.parseInt(nums[i]);
            gpa += numbers[i]*Integer.parseInt(nums[i]);
        }
        System.out.println(sum);
        System.out.println(gpa/sum);
    }
}
