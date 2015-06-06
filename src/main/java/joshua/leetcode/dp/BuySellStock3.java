package joshua.leetcode.dp;

public abstract class BuySellStock3 {
	
	 /**
	  * Say you have an array for which the ith element is the price of a given stock on day i.

		Design an algorithm to find the maximum profit. You may complete at most two transactions.
	  * @param prices
	  * @return
	  */
	 public abstract int maxProfit(int[] prices);
	 
	 /**
	  * a little verbose way.
	  * @author joy
	  *
	  */
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
			 /*for every time point, we know the maximum profit if we conduct one transaction ended at/before this point
			   and the maximum profit if we conduct one transaction started at/after this point
			   Since we at most can have two transactions.  
			 */
			 int max=Math.max(startAt[0],endAt[prices.length-1]);
			 for(int k=0;k<prices.length-2;k++){
				 max=Math.max(endAtMax[k]+startAtMax[k+1],max);
			 }
			 return max;
		}
	 }

	 /**
	  * 
	  * 这道题是Best Time to Buy and Sell Stock的扩展，现在我们最多可以进行两次交易。
	  * 我们仍然使用动态规划来完成，事实上可以解决非常通用的情况，也就是最多进行k次交易的情况。
		这里我们先解释最多可以进行k次交易的算法，然后最多进行两次我们只需要把k取成2即可。我们还是使用“局部最优和全局最优解法”。
		我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。
		下面我们来看递推式，全局的比较简单，

		global[i][j]=max(local[i][j],global[i-1][j])，
		也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。对于局部变量的维护，递推式是

		local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
		也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），第二个量则是取local第i-1天j次交易，然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。

		如果上面不好理解，可以这样理解：对于局部变量，第i天最多进行j次交易，可以分两种情况：
		
		1)一是这第j次交易就是当天买入当天卖出的，那么最大收益就是  global[i-1][j-1] + max(diff, 0), diff为第i天当天股价变化。
		2)另一种情况是：第j次交易早就买入了，但是拖到第i天当天才卖出。这种情况分析起来有点绕，但是可以视为：第i-1天卖出的收益 + 第i天当天的股价变化，所以就是local[i-1][j] + diff. 
		这样想就好懂了。
	  
	  * @see <a href="http://www.cnblogs.com/EdwardLiu/p/4008162.html">Leetcode: Best Time to Buy and Sell Stock III</a>
	  * 
	  */
	 static class Solution2 extends BuySellStock3{

		@Override
		public int maxProfit(int[] prices) {
			/*
			 * at each price point T:
			 * global[i] means the maximum profit if we have at most i transactions which all end before T;
			 * local[i] means the maximum profit if we have at most i-1 transaction which all end before T-1 and one transaction ends at T;
			 * i varies in 0,1,2
			 * (at most 2 transactions, 0 case is counted in only for the convenience of calculating 1 case) 
			 */
			int[] global=new int[]{0,0,0};
			int[] local=new int[]{0,0,0}; 
			for(int i=1;i<prices.length;i++){
				int diff=prices[i]-prices[i-1];
				/*for j,  can only calculate it descendingly*/
				for(int j=2;j>=1;j--){
					local[j]=Math.max(global[j-1]+Math.max(0, diff), local[j]+diff);//update local[j]
					global[j]=Math.max(local[j], global[j]);//update global[j]
				}
			}
			return global[2];
		}
		 
	 }
}
