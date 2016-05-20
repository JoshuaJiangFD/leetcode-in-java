package joshua.leetcode.dp;

public abstract class BuySellStock2 {
    /**
     * You have an array for which the ith element is the price of a given stock on day i.<br>
     * <p/>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like.<br>
     * (ie, buy one and sell one share of the stock multiple times). <br>
     * However, you may not engage in multiple transactions at the same time.<br>
     * (ie, you must sell the stock before you buy again).<br>
     *
     * @param prices
     * @return
     * @see <a href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">leetcode link</a>
     */
    public abstract int maxProfit(int[] prices);


    static class Solution extends BuySellStock2 {

        /**
         * imaging connecting all stock price to a line chart,
         * need to capture all up slope and summarize all the profit we can get
         */
        @Override
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            if (prices == null || prices.length <= 1)
                return maxProfit;
            boolean holding = false;
            int curMin = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int cur = prices[i];
                if (holding) {
                    if (cur < prices[i - 1]) {
                        maxProfit += prices[i - 1] - curMin;
                        holding = false;
                    }
                } else {
                    if (cur > prices[i - 1]) {
                        holding = true;
                        curMin = prices[i - 1];
                    }
                }
            }
            if (holding) {
                maxProfit += prices[prices.length - 1] - curMin;
            }
            return maxProfit;
        }
    }
}
