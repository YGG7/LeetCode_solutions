package LeetCode;

public class NthDigit {
    public int findNthDigit(int n) {
        int currDigit = 1;
        long count = 9;
        long start = 1;
        while (n>count) {
            n-=count;
            currDigit++;
            start*=10;
            count = 9*start*currDigit;
        }
        long num = start+(n-1)/currDigit; // (0-1)/1 == -1
        int restDigit = (n-1)%currDigit;
        return Long.toString(num).charAt(restDigit)-'0';
    }

    public static void main(String[] args) {
        NthDigit nd = new NthDigit();
        System.out.println(nd.findNthDigit(0));
    }
}
