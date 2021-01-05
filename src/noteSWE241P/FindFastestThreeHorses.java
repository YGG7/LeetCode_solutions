package noteSWE241P;

import javax.management.relation.RelationNotFoundException;
import java.util.Arrays;
import java.util.Random;

public class FindFastestThreeHorses {
    public static void main(String[] args) throws InterruptedException {
//        while (true) {
//            Thread.sleep(200);
//            Random rd = new Random();
//            System.out.println(rd.nextInt() % 100);
//        }
        Random rd = new Random();
        int[] horses = new int[25];
        for (int i=0; i<horses.length; i++) {
            horses[i] = Math.abs(rd.nextInt()%100);
        }
        printHorses(horses);
        find(horses);

    }
    public static void printHorses(int[] horses) {
        for (int horse : horses) {
            System.out.printf("%2d ", horse);
        }
        System.out.print("\n");
    }

    public static int[] find(int[] horses) {
        int[][] fRacedHorses = new int[5][5];
        int[] result = new int[3];
        int[] indice = new int[3];
        for (int i=0; i<5; i++) {
            int[] tmp = Arrays.copyOfRange(horses, i*5, i*5+5);
            Arrays.sort(tmp);
//            printHorses(tmp);
            fRacedHorses[i] = tmp;
        }

        for (int i=0; i<3;i++) {
            for (int j=0; j<5;j++) {

            }
        }
        return null;
    }
}
