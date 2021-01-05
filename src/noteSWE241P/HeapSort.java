package noteSWE241P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {4,2,7,13,3,1,8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int element:arr) {
            minHeap.offer(element);
        }
        for(int i=0; i<arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }
}
