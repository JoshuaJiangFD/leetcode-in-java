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

		 /**
		  * an unnatural case of buying and selling stocks-- you never know what market looks like at next moment.
		  * Under this special hypothesis, the best strategy would be:
		  * 1) at every moment, hold the max profit you can get the previous market as <code>maxProfit</code>,
		  * and your bid price;
		  * 2) at next moment: compare the price with your bid price, 
		  * a)if lower now, change your bid price, which mean:
		  *     you have the possibility to gain more profit by buying stock at this moment, but only possibility for now
		  *     if the current price is high than your bid price before, then no need to consider buying stock at this moment,
		  *     'cause you can gain more just with your previous bid price, and wait the next high price to sell it;
		  *     
		  * b) instead, if higher now, you should only consider whether it increase your profit by selling it now, that means:
		  *    maxProfit=max[(current price-bid price),maxProfit]    
		  */
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
