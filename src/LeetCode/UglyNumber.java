package LeetCode;

/**
 * Jianzhi 49. https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class UglyNumber {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] arr_un = new int[n];
        arr_un[0] = 1;
        int a, b, c;
        a = b = c = 0;
        for (int i = 1; i<n; i++) {
            int un1 = arr_un[a]*2, un2 = arr_un[b]*3, un3 = arr_un[c]*5;
            arr_un[i] = Math.min(Math.min(un1, un2), un3);
            if (un1 == arr_un[i]) a++;
            if (un2 == arr_un[i]) b++;
            if (un3 == arr_un[i]) c++;
        }
        return arr_un[n-1];
    }
}
