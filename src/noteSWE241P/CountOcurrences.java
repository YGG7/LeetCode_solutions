package noteSWE241P;

public class CountOcurrences {
    public static int count(int[] arr, int x) {
        int firstIdx = first(arr, 0, arr.length-1, x);
        int lastIdx = last(arr, 0, arr.length-1, x);
        if (firstIdx==-1) return 0;
        else return (lastIdx-firstIdx+1);
    }

    private static int first(int[] arr, int low, int high, int x) {
        while (low<=high) {
            int mid = (low+high)/2; // there is an overflow risk,
            if ((mid==0||arr[mid-1]<x) && arr[mid]==x) return mid;
            else if (arr[mid]<x) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    private static int last(int[] arr, int low, int high, int x) {
        while (low<=high) {
            int mid = (low+high)/2;
            if ((mid==arr.length-1||arr[mid+1]>x) && arr[mid]==x) return mid;
            else if (arr[mid]>x) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    private static int first2(int[] arr, int low, int high, int x) {
        int firstIdx = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (arr[mid]==x) {
                firstIdx = mid;
                high = mid-1; // tend to find the previous x
            }
            else if (arr[mid]>x) high = mid-1;
            else low = mid+1;
        }
        return firstIdx;
    }

    private static int last2(int[] arr, int low, int high, int x) {
        int lastIdx = -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (arr[mid]==x) {
                lastIdx = mid;
                low = mid+1; // tend to find the latter x
            }
            else if (arr[mid]>x) high = mid-1;
            else low = mid+1;
        }
        return lastIdx;
    }

}
