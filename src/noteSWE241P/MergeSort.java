package noteSWE241P;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {4,2,7,13,3,1,8};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int start, int end) {
        if(start<end) {
            int median = (start+end)/2;
            sort(arr, start, median);
            sort(arr, median+1, end);
            merge(arr, start, median, end);
        }
    }

    private static void merge(int[] arr, int start, int median, int end) {
        int len1 = median-start+1;
        int len2 = end-median;
        int[] subarr1 = new int[len1];
        int[] subarr2 = new int[len2];
        // need more modifications to improve efficiency
        System.arraycopy(arr, start, subarr1, 0, len1);
        System.arraycopy(arr, median+1, subarr2, 0, len2);
        int curr1=0, curr2=0, curr=start;
        while(curr1<len1 && curr2<len2) {
            if(subarr1[curr1]<subarr2[curr2]) arr[curr++] = subarr1[curr1++];
            else arr[curr++] = subarr2[curr2++];
        }
        while(curr1<len1) {
            arr[curr++] = subarr1[curr1++];
        }
        while(curr2<len2) {
            arr[curr++] = subarr2[curr2++];
        }
    }
}
