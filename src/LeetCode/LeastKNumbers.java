package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Jianzhi 40. https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class LeastKNumbers {
    public static void main(String[] args) {
        LeastKNumbers ln = new LeastKNumbers();
        int[] a = {4,2,7,13,3,1,8};
        System.out.println(Arrays.toString(ln.getLeastNumbers(a, 3)));
    }
    public int[] getLeastNumbers(int[] arr, int k) {
//        return getLeastNumbersHeap(arr, k);
        return getLeastNumbersPivot(arr, k);
    }

    private int[] getLeastNumbersPivot(int[] arr, int k) {
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        partitionArrayCopy(arrCopy, 0, arrCopy.length-1, k);
        int[] res = new int[k];
        System.arraycopy(arrCopy, 0, res, 0, k);
        return res;
    }

    private void partitionArrayCopy(int[] arr, int start, int end, int k) {
        if(start<=end) { // different from quicksort
                         // we need to consider windows only having one element
            int pivot = partition(arr, start, end);
            int leftNum = pivot-start+1;
            if(leftNum==k) return;
            else if(leftNum>k) {
                partitionArrayCopy(arr, start, pivot-1, k);
            }
            else {
                partitionArrayCopy(arr, pivot+1, end, k-leftNum);
            }
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivotVal = arr[end];
        int slow = start;
        for(int i = start; i<end; i++) {
            if(arr[i]<pivotVal) {
                swap(arr, i, slow);
                slow++;
            }
        }
        swap(arr, end, slow);
        return slow;
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private int[] getLeastNumbersHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (x, y)->Integer.compare(y,x));
        for(int i=0; i<k; i++) {
            maxHeap.offer(arr[i]);
        }
        for(int i=k; i<arr.length; i++) {
            if(maxHeap.peek()!=null && arr[i]<maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
