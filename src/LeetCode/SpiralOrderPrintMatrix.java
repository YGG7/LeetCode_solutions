package LeetCode;

import java.util.Arrays;

/**
 * Jianzhi 29. https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class SpiralOrderPrintMatrix {
    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(spiralOrder(m)));
    }

    static public int[] spiralOrder(int[][] matrix) {
        int numRows = matrix.length;
        if (numRows==0) return new int[0];
        int numColumns = matrix[0].length;
        int i=0, j=0, resIdx=0, left=0, right=numColumns-1, top=0, bottom=numRows-1;
        int[] result = new int[numRows*numColumns];
        int[] nextDir = {0,1};
        while (resIdx<numRows*numColumns) {
            result[resIdx] = matrix[i][j];
            resIdx++;
            if(j+nextDir[1]>right) {
                nextDir[0] = 1;
                nextDir[1] = 0;
                top++;
            } else if(j+nextDir[1]<left) {
                nextDir[0] = -1;
                nextDir[1] = 0;
                bottom--;
            } else if(i+nextDir[0]>bottom) {
                nextDir[0] = 0;
                nextDir[1] = -1;
                right--;
            } else if(i+nextDir[0]<top) {
                nextDir[0] = 0;
                nextDir[1] = 1;
                left++;
            }
            i = i+nextDir[0];
            j = j+nextDir[1];
        }
        return result;
    }
}
