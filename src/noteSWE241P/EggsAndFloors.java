package noteSWE241P;

import java.util.Random;

public class EggsAndFloors {
    public static void main(String[] args) throws InterruptedException {
        Random rd = new Random();
        while (true) {
            Thread.sleep(500);
            int maxFloor = 1000;
            int aimFloor = rd.nextInt(maxFloor)+1;
            System.out.printf("Highest floor: %d, The lowest floor for which egg will break: %d\n",maxFloor,aimFloor);
            System.out.printf("Result using infinite eggs: %d\n", findFloorIE(maxFloor, aimFloor));
            System.out.printf("Result using two eggs: %d\n", findFloor2E(maxFloor, aimFloor));
            System.out.print("\n");
        }
    }
    /**
     * find the lowest floor for which egg will break
     * use binary search
     * assume eggs are infinite
    */
    public static int findFloorIE(int maxFloor, int aimFloor) {
        int currentFloor = maxFloor/2;
        int lowestBreak = maxFloor, highestSurvive = 1;
        int count =0;
        while(highestSurvive+1!=lowestBreak) {
            count+=1;
            if(isBroken(currentFloor, aimFloor)) {
//                lowestBreak = Math.min(lowestBreak, currentFloor);
                lowestBreak = currentFloor;
            } else {
//                highestSurvive = Math.max(highestSurvive, currentFloor);
                highestSurvive = currentFloor;
            }
            currentFloor = (highestSurvive+lowestBreak)/2;
        }
        System.out.println("experiment count: "+count);
        return lowestBreak;
    }

    /**
     * given 2 eggs
     */
    public static int findFloor2E(int maxFloor, int aimFloor) {
        int firstStep =(int)Math.ceil(Math.sqrt(2*maxFloor+0.25)-0.5);
        int step = firstStep;
        int currentFloor = firstStep;
        int count =0;
        while(true) {
            count+=1;
            if(isBroken(currentFloor, aimFloor)) {
                for (int i=currentFloor-step+1;i<currentFloor;i++) {
                    count +=1;
                    if (isBroken(i, aimFloor)) {
                        currentFloor = i;
                        break;
                    }
                }
                break;
            } else {
                step -= 1;
                currentFloor += step;
            }
        }
        System.out.println("experiment count: "+count);
        return currentFloor;
    }

    public static boolean isBroken(int currentFloor, int aimFloor) {
        return currentFloor>=aimFloor;
    }

}
