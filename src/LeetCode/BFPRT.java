package LeetCode;

import java.util.Arrays;

public class BFPRT {
    public static void main(String[] args) {
        int [] array ={4,45,32,67,5,78,4556,781,1,3,43,765,9,22};
        int[] arrayCP1 = new int[array.length];
        int[] arrayCP2 = new int[array.length];
        System.arraycopy(array, 0, arrayCP1, 0, array.length);
        System.arraycopy(array, 0, arrayCP2, 0, array.length);
        Arrays.sort(arrayCP2);
        System.out.println(Arrays.toString(arrayCP2));

        int n3 = bfprt(arrayCP1, 0, arrayCP1.length-1, 3);
        int n4 = bfprt(arrayCP1, 0, arrayCP1.length-1, 4);
        int n5 = bfprt(arrayCP1, 0, arrayCP1.length-1, 5);
        System.out.println(n3+" "+n4+" "+n5);
    }

    public static int bfprt(int[] arr, int start, int end, int k) {
        if(start==end) return arr[start];
        int pivot = getMedianOfMedian(arr, start, end);
        int pivotIdx = partition(arr, start, end, pivot);
        int num = pivotIdx-start+1; // the number of elements less than pivot and pivot itself

        if(num==k) return arr[pivotIdx];
        else if(num<k) return bfprt(arr,pivotIdx+1, end, k-num);
        else return bfprt(arr, start, pivotIdx-1, k);
    }

    private static int getMedianOfMedian(int[] arr, int start, int end) {
        int num = end-start+1;
        int groupNum = num/5 + (num%5==0?0:1);
        int[] medians = new int[groupNum];
        for (int i=0; i<groupNum; i++) {
            int iStart = start+i*5;
            medians[i] = getMedian(arr, iStart, Math.min(iStart+4, end));
        }
        return bfprt(medians, 0, groupNum-1, groupNum/2+groupNum%2);
    }

    private static int getMedian(int[] arr, int start, int end) {
        insertionSort(arr, start, end);
        int sum = start+end;
        int midIdx = sum/2 + (sum%2);
        return arr[midIdx];
    }

    private static void insertionSort(int[] arr, int start, int end) {
        for(int i=start+1; i<=end; i++) {
            int currIdx = i;
            while (currIdx>start&&arr[currIdx]<arr[currIdx-1]){
                swap(arr, currIdx, currIdx-1);
                currIdx--;
            }
        }
    }

    /**
     * @return the index of pivot
     */
    private static int partition(int[] arr, int start, int end, int pivot) {
        for(int i=start; i<=end; i++) {
            if(arr[i]==pivot) {
                swap(arr, i, end);
                break;
            }
        }
        int j = start;
        for(int i=start; i<end; i++) {
            if(arr[i]<pivot) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, j, end);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
