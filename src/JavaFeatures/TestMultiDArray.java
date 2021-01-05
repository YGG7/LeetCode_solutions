package JavaFeatures;


import java.util.Arrays;
import java.util.Random;

public class TestMultiDArray {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] arr = new int[4][3];
        int[][] arr2 = arr;
        for (int i=0; i<arr.length; i++) {
            Arrays.fill(arr[i], Math.abs(random.nextInt()%10));

        }
        System.out.println(toString2DArray(arr));
        System.out.println(toString2DArray(arr2));
        System.out.println(arr==arr2?"true":"false");

    }

    private static String toString2DArray(int[][] arr) {
        if (arr==null || arr[0].length<=0) return null;
        int nRow = arr.length, nCol = arr[0].length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<nRow; i++) {
            for (int j=0; j<nCol; j++) {
                builder.append(arr[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
