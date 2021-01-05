package noteSWE241P;

public class insertionSort {
    public static void sort(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int j=i;
            while (j>0&&arr[j]<arr[j-1]) {
                swap(arr, j, j-1);
                j=j-1;
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
