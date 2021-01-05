package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;

public class AustralianVoting {
    enum countVotingInfo {
        PERCENT, MAXINDEX, MININDEX, ISSAME
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        int caseNum = Integer.parseInt(br.readLine().trim());
        br.readLine();

        for (int casei=0; casei<caseNum; casei++) {
            int num = Integer.parseInt(br.readLine().trim());
            String[] candiName = new String[num];
            boolean[] aliveCandi = new boolean[num];
            Arrays.fill(aliveCandi, true);
            int[][] ballots = new int[num][num]; // 1st dimension: candidate number
                                                 // 2nd dimension: choices
            for (int ic=0; ic<num; ic++) {
                candiName[ic] = br.readLine().trim();
            }

            String ballotStr = "";
            while ((ballotStr = br.readLine()) != null && !ballotStr.equals("")) {
                String[] ballotStrArr = ballotStr.trim().split(" ");
//                System.out.println(" ");
                for (int i=0; i<num; i++) {
                    ballots[Integer.parseInt(ballotStrArr[i])-1][i] += 1;
                }
            }
//            System.out.println(Arrays.toString(ballots));
//            printBallots(ballots, num);
            double firstchoice_percent;
            int max_index;
            int min_index;
            boolean isSame;
            do {
                EnumMap<countVotingInfo, Object> report = countVoting(ballots, aliveCandi);
                firstchoice_percent = (double)report.get(countVotingInfo.PERCENT);
                max_index = (int)report.get(countVotingInfo.MAXINDEX);
                min_index = (int)report.get(countVotingInfo.MININDEX);
                isSame = (boolean)report.get(countVotingInfo.ISSAME);
                if (firstchoice_percent>0.5) break;
                if (isSame) break;
                aliveCandi[min_index] = false;
            } while (true);

            if (firstchoice_percent>0.5) {
                System.out.println(candiName[max_index]);
            }
            else if(isSame) {
                for (int i=0;i<num;i++) {
                    if (aliveCandi[i]) System.out.println(candiName[i]);
                }
            }
        }
    }

    public static EnumMap<countVotingInfo, Object> countVoting(int[][] ballots, boolean[] alivecandi) {
        int firstchoice_sum =0, max=0, max_index=0, min=Integer.MAX_VALUE, min_index=0, countVisit=0, lastvisted=-1;
        boolean isSame = true;
        for (int i=0;i<alivecandi.length;i++) {
            if (!alivecandi[i]) continue;

            countVisit += 1;
            if (countVisit==1) lastvisted = i;

            if (ballots[i][0] != ballots[lastvisted][0]) isSame=false;
            firstchoice_sum += ballots[i][0];
            if (ballots[i][0] > max) {
                max = ballots[i][0];
                max_index = i;
            }
            if (ballots[i][0] < min) {
                min = ballots[i][0];
                min_index = i;
            }
            lastvisted = i;
        }
        double firstchoice_percent = (double)max/(double)firstchoice_sum;
        EnumMap<countVotingInfo, Object> report = new EnumMap<>(countVotingInfo.class);
        report.put(countVotingInfo.PERCENT, firstchoice_percent);
        report.put(countVotingInfo.MAXINDEX, max_index);
        report.put(countVotingInfo.MININDEX, min_index);
        report.put(countVotingInfo.ISSAME, isSame);
        return report;
    }

    public static void printBallots(int[][] ballots, int d) {
        System.out.print("[");
        for (int i=0; i<d; i++) {
            for (int j=0; j<d; j++) {
                System.out.printf("\t%d,\t", ballots[i][j]);
            }
            if (i==d-1) System.out.print("]\n");
            else System.out.print("\n");
        }
    }
}
