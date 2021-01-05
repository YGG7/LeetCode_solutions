package noteSWE241P;

public class OneSidedBinarySearch {
    public static void main(String[] args) {
        int[] test = {-10, -5, 4, 6, 8, 10, 11};
        System.out.println("position of 10: "+search(test, 10));
    }

    public static int search(int[] arr, int target) {
        if (arr==null) return -1;
        int len = arr.length;
        int lg = (int)Math.ceil(Math.log(len)/Math.log(2)); // java doesn't have built-in log2 function
        int index = 0;
        for (int i=lg-1; i>=0; i--) {
            if (arr[index]==target) return index;
            int newIndex = index|(1<<i);
            if (newIndex<len && arr[newIndex]<=target) index=newIndex;
        }
        return (arr[index]==target)?index:-1;
    }
}
