package joshua.leetcode.dp;

public abstract class BuySellStock4 {

	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	   Design an algorithm to find the maximum profit. You may complete at most k transactions.
	   
	   Note:
	   	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 * @param k
	 * @param prices
	 * @return
	 */
	public abstract int maxProfit(int k, int[] prices);

	/**
	 * A variation of at most 2 transaction case.
	 * 
	 * @see {@link joshua.leetcode.dp.BuySellStock3}
	 * @author joy
	 *
	 */
	static class Solution1 extends BuySellStock4 {

		@Override
		public int maxProfit(int k, int[] prices) {
			if (prices.length < 2 || prices == null)
				return 0;
			int len = prices.length;
			int[][] local = new int[len][k + 1];
			int[][] global = new int[len][k + 1];
			for (int size = 0; size <= k; size++) {
				local[0][size] = 0;
				global[0][size] = 0;
			}
			for (int i = 1; i < len; i++) {
				int diff = prices[i] - prices[i - 1];
				for (int size = 1; size <= k; size++) {
					local[i][size] = Math.max(
							global[i - 1][size - 1] + Math.max(diff, 0),
							local[i - 1][size] + diff);
					global[i][size] = Math.max(global[i][size],
							local[i][size]);
				}
			}
			return global[len - 1][k];
		}
	}
	
	static class Solution2 extends BuySellStock4 {

		@Override
		public int maxProfit(int k, int[] prices) {
			if(prices.length<2||prices==null)
				return 0;
			int len=prices.length;
			int[] local=new int[k+1];
			int[] global=new int[k+1];
			for (int size = 0; size <= k; size++) {
				local[size] = 0;
				global[size] = 0;
			}

			for(int i=1;i<len;i++){
				int diff=prices[i]-prices[i-1];
				/*for size,  can only calculate it descendingly*/
				for(int size=k;size>0;size--){
					local[size]=Math.max(global[size-1]+Math.max(diff, 0), local[size]+diff);
					global[size]=Math.max(global[size], local[size]);
				}
			}
			return global[k];
		}
	}
}
