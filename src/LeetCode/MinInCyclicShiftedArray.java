package LeetCode;

/**
 * Jianzhi 11. https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinInCyclicShiftedArray {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int upper=len-1, lower = 0, current = -1;
        while (upper>lower) {
            current = (upper+lower)/2;
            if(numbers[current]>numbers[upper]) {
                lower = current+1;
            } else if (numbers[current]<numbers[upper]) {
                upper = current;
            } else {
                upper -=1;
            }
        }
        return numbers[lower];
    }
}
