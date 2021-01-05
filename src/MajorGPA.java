import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class MajorGPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine().trim();
        String credit = sc.nextLine().trim();
        String[] scores = score.split(" ");
        String[] credits = credit.split(" ");
        if(scores.length!=credits.length) {
            System.out.println("ERROR");
            return;
        }
        double majorGPA = 0.0;
        int totalCredits = 0;
        for (int i=0;i<scores.length;i++) {
            majorGPA += Double.parseDouble(scores[i]) * Integer.parseInt(credits[i]);
            totalCredits += Integer.parseInt(credits[i]);
        }
        majorGPA /= totalCredits;
        System.out.println(majorGPA+" in "+totalCredits+" credits");
    }
}
