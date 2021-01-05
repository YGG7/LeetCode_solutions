package LeetCode;


/**
 * Jianzhi 63. https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int currMinPrice = Integer.MAX_VALUE, currMaxProfit = 0;
        for (int price:prices) {
            currMinPrice = Math.min(currMinPrice, price);
            currMaxProfit = Math.max(currMaxProfit, price-currMinPrice);
        }
        return currMaxProfit;
    }
}
