package joshua.leetcode.dp;

/**
 * @author joy
 */
public abstract class BuySellStock {

	/**
	 * <b>Best Time to Buy and Sell Stock</b><br>
	 * Say you have an array for which the ith element is the price of a given stock on day i.</br>
	
	 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),</br> 
	 * design an algorithm to find the <b>maximum profit</b>.</br>
	 * 
	 * @see <a href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/">leetcode link</a>
	 * @param prices
	 * @return
	 */
	 public abstract int maxProfit(int[] prices) ;
	 
	 static class Solution1 extends BuySellStock{

		@Override
		public int maxProfit(int[] prices) {
			int maxProfit=0;
			if(prices==null||prices.length==1)
				return maxProfit;
			int min=prices[0];
			for(int i=1;i<prices.length;i++){
				if(prices[i]<min){
					min=prices[i];
					continue;
				}
				maxProfit=Math.max(maxProfit, prices[i]-min);	
			}
			return maxProfit;
		}
	 }
}
