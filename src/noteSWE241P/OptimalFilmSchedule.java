// The Algorithm Design Manual
// page 25
package noteSWE241P;

import java.util.ArrayList;
import java.util.List;

public class OptimalFilmSchedule {
    public static void main(String[] args) {
        int[] startPoints =  {0,2,3,5,7,10,12,13,16};
        int[] endPoints =    {6,4,8,9,11,16,15,17,18};
        boolean[] films = new boolean[startPoints.length];
        for (int i=0; i<films.length;i++) {
            films[i] = false;
        }
        printFilmsTime(startPoints, endPoints);
        List<Integer> schedule = new ArrayList<Integer>();
        while (!isAllVisited(films)) {
            int filmIndex = solution(startPoints, endPoints, films);
            schedule.add(filmIndex);
            System.out.printf("%2d",filmIndex);
            printFilmTime(startPoints[filmIndex], endPoints[filmIndex]);
        }
        for (int value: schedule) {
            System.out.printf("%2d ", value);
        }
    }

    private static void printFilmsTime(int[] sp, int[] ep) {
        for (int value : sp) {
            System.out.printf("%2d ", value);
        }
        System.out.print("\n");
        for (int value : ep) {
            System.out.printf("%2d ", value);
        }
        System.out.print("\n");

        for (int i=0; i<sp.length; i++) {
            System.out.printf("%2d",i);
            for (int j=0; j<sp[i];j++) {
                System.out.print(" ");
            }
            for (int j=0; j<ep[i]-sp[i];j++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }
    private static void printFilmTime(int sp, int ep) {
        for (int j=0; j<sp;j++) {
            System.out.print(" ");
        }
        for (int j=0; j<ep-sp;j++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
    private static boolean isAllVisited(boolean[] f) {
        for (boolean value : f) {
            if (!value) return false;
        }
        return true;
    }
    private static int solution(int[] sp, int[] ep, boolean[] f) {
        int minEnd = Integer.MAX_VALUE;
        int minEndIndex = -1;
        for (int i=0; i<sp.length; i++) {
            if (!f[i] && ep[i]<minEnd) {
                minEnd = ep[i];
                minEndIndex = i;
            }
        }
        f[minEndIndex] = true;
        for (int i=0; i<sp.length; i++) {
            if (sp[i]<minEnd) {
                f[i] = true;
            }
        }
        return minEndIndex;

    }
}

