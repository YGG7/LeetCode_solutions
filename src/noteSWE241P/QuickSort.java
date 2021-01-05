package noteSWE241P;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4,2,7,13,3,1,8};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int start, int end) {
        if(start<end) { // only window size >=2, sort is necessary
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot-1);
            sort(arr, pivot+1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivotVal = arr[end];
        int front = start;
        // more concise, more swaps but in the same asymptotic complexity
        // comparing with front-back pointers method
        for(int i=start; i<end; i++) {
            if(arr[i]<pivotVal) {
                swap(arr, i, front);
                front++;
            }
        }
        /*
        int front = start, back = end-1;
        while (front<=back) { // leq for cases of window size==2
            if(arr[front]>pivotVal && arr[back]<pivotVal) {
                swap(arr, front, back);
                front++;
                back--;
            }
            else if (arr[front]<pivotVal && arr[back]<pivotVal) {
                front++;
            }
            else if (arr[front]>pivotVal && arr[back]>pivotVal) {
                back--;
            }
            else {
                front++;
                back--;
            }
        }
        */
        swap(arr, end, front);
        return front;
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
