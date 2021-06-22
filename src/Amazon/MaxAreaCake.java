package Amazon;

import java.util.Arrays;

/**
 * LC 1465. https://leetcode-cn.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class MaxAreaCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if (h <= 0 || w <= 0 || horizontalCuts == null || verticalCuts == null) return 0;
        int mod = (int) Math.pow(10, 9) + 7;
        long maxArea = 0;
        long maxh = 0, maxv = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxh = Math.max(maxh, horizontalCuts[0]);
        maxh = Math.max(maxh, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxv = Math.max(maxv, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxv = Math.max(maxv, verticalCuts[0]);
        maxv = Math.max(maxv, w - verticalCuts[verticalCuts.length - 1]);
        maxArea = (maxh * maxv) % mod;

        return (int) maxArea;
    }

    public int maxArea2(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if (h <= 0 || w <= 0 || horizontalCuts == null || verticalCuts == null) return 0;
        int mod = (int) Math.pow(10, 9) + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxh = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long maxv = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            maxv = Math.max(maxv, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int) ((maxh * maxv) % mod);
    }
}
