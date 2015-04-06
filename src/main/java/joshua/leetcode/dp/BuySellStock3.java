package joshua.leetcode.dp;

public abstract class BuySellStock3 {
	
	 /**
	  * Say you have an array for which the ith element is the price of a given stock on day i.

		Design an algorithm to find the maximum profit. You may complete at most two transactions.
	  * @param prices
	  * @return
	  */
	 public abstract int maxProfit(int[] prices);
	 
	 static class Solution1 extends BuySellStock3{

		@Override
		public int maxProfit(int[] prices) {
			 
			 if(prices==null||prices.length<2)
				 return 0;
			 int[] endAt=new int[prices.length];
			 int[] endAtMax=new int[prices.length];
			 endAt[0]=endAtMax[0]=0;
			 int[] startAt=new int[prices.length];
			 int[] startAtMax=new int[prices.length];
			 startAt[prices.length-1]=startAtMax[prices.length-1]=0;
			 for(int i=1;i<prices.length;i++){
				 int spread=prices[i]-prices[i-1];
				 endAt[i]=Math.max(0, spread+endAt[i-1]);
				 endAtMax[i]=Math.max(endAt[i], endAtMax[i-1]);
			 }
			 for(int j=prices.length-2;j>-1;j--){
				 int spread=prices[j+1]-prices[j];
				 startAt[j]=Math.max(0, spread+startAt[j+1]);
				 startAtMax[j]=Math.max(startAt[j], startAtMax[j+1]);
			 }
			 /*for every time point, we know the maximum profit if all transactions ended at this point
			   and the maximum profit if all transactions started at this point
			   now we at most can have two transactions.  
			 */
			 int max=Math.max(startAt[0],endAt[prices.length-1]);
			 for(int k=0;k<prices.length-2;k++){
				 max=Math.max(endAtMax[k]+startAtMax[k+1],max);
			 }
			 return max;
		}
	 }
}
