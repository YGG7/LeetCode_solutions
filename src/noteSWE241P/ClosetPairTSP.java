package noteSWE241P;

public class ClosetPairTSP {
    public static void main(String[] args) {
        int [][]m = {
                {0,2,5,1,5},
                {2,0,3,3,7},
                {5,3,0,6,10},
                {1,3,6,0,4},
                {5,7,10,4,0}
        };
        int vertexNum = 5;
        int[] shape = {5,5};
        int[] vertexFlag = {0,0,0,0,0};
        printArray2D(m,shape[0], shape[1]);
        for (int i=0;i<vertexNum-1;i++) {
            int dist = Integer.MAX_VALUE;
            for (int j=0;j<vertexNum;j++) {
                if (m[i][j]<dist) {
                    dist = m[i][j];
                }
            }
        }

    }

    public static void printArray2D(int[][] a, int shapeX, int shapeY) {
        for (int i=0;i<shapeX;i++) {
            for (int j=0;j<shapeY;j++) {
                System.out.printf("%2d ", a[i][j]);
            }
            System.out.print("\n");
        }
    }
}
