package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = "";
        while((line = br.readLine())!=null) {
            String[] arrS = line.trim().split(" ");
            int[] set = new int[arrS.length];
            for (int i=0; i<arrS.length; i++) {
                set[i] = Integer.parseInt(arrS[i]);
            }
            int[] subset = sampling(set, 5);
            System.out.println(Arrays.toString(set));
            System.out.println(Arrays.toString(subset));
        }

    }

    public static int[] sampling(int[] set, int k) {
        int[] subset = new int[k];
        Random rd = new Random();
        int index = 0;
        for (int element:set) {
            if (index<k) subset[index] = element;

            int rindex = rd.nextInt(index+1);
            if (rindex<k) subset[rindex] = element;
            index+=1;
        }
        return subset;
    }
}
