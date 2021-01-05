package LeetCode;

public class CountReversePairs {
    public int reversePairs(int[] nums) {
        if (nums==null || nums.length<2) return 0;
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] arr, int start, int end) {
        if (start>=end) return 0;
        else {
            int mid = (start+end)/2;
            int count1 = mergeSort(arr, start, mid);
            int count2 = mergeSort(arr, mid+1, end);
            int count3 = 0;
            int[] temp = new int[end-start+1];
            int curr1=start, curr2=mid+1, curr=0;
            // moving curr in sub-array means we have cleared all reverse pairs containing current element
            while (curr1<=mid && curr2<=end) {
                if (arr[curr1]>arr[curr2]) {
                    temp[curr] = arr[curr2];
                    count3+=mid-curr1+1;
                    curr2++;
                    curr++;
                }
                else {
                    temp[curr] = arr[curr1];
                    curr1++;
                    curr++;
                }
            }
            while (curr1<=mid) {
                temp[curr++] = arr[curr1++];
            }
            while (curr2<=end) {
                temp[curr++] = arr[curr2++];
            }
            System.arraycopy(temp, 0, arr, start, end-start+1);
            return count1+count2+count3;
        }
    }
}
