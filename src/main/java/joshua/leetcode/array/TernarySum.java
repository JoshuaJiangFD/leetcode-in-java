package joshua.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 3Sum</br>
 * <b>tags:</b>  Array, Two pointers.
 * @see <a href="https://oj.leetcode.com/problems/3sum/">3sum</a>
 * @author Joshua.Jiang
 *
 */
public abstract class TernarySum {
	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	 * 
	 * Find all unique triplets in the array which gives the sum of zero.

		Note:
		Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
		The solution set must not contain duplicate triplets.
		    For example, given array S = {-1 0 1 2 -1 -4},
		
		    A solution set is:
		    (-1, 0, 1)
		    (-1, -1, 2)
		    
	 * @param num
	 * @return
	 */
	 public abstract List<List<Integer>> threeSum(int[] num);
	 
	 
	 /**
	  * A derivation of DualSum problem.
	  * Time Complexity: o(n<sup>2</sup>)
	  * 
	  * @see {@link DualSum}
	  * @author joy
	  *
	  */
	 static class Solution1 extends TernarySum{

		@Override
		public List<List<Integer>> threeSum(int[] num) {
			List<List<Integer>> result=new ArrayList<List<Integer>>();
			if(num.length<3)
				return result;
			//1. sort the array
			List<Triple> set=new ArrayList<Triple>();
			Arrays.sort(num);
			//main loop to find all the result.
			for(int i=0;i<num.length-2;i++){
				int head=i+1;
				int tail=num.length-1;
				int curValue=num[i];
				if(curValue>0)
					break;
				int target=0-curValue;
				while(head<tail){
					int sum=num[head]+num[tail];
					if(sum<target)
						head++;
					else if(sum>target)
						tail--;
					else
					{
						Triple tri=new Triple(curValue,num[head],num[tail]);
						if(!set.contains(tri))
							set.add(tri);
						head++;
						tail--;
					}
				}
			}
			for(Triple tri:set){
				List<Integer> res=new ArrayList<Integer>();
				res.add(tri.x);
				res.add(tri.y);
				res.add(tri.z);
				result.add(res);
			}
			return result;
			
		}
		
		class Triple{
			int x;
			int y;
			int z;
			
			public Triple(int x,int y,int z){
				this.x=x;
				this.y=y;
				this.z=z;
			}
			
			@Override
			public boolean equals(Object obj) {
				if(obj==null)
					return false;
				if(!(obj instanceof Triple))
					return false;
				Triple another=(Triple)obj;
				return another.x==this.x&& another.y==this.y &&another.z==this.z;		
			}
			
		}
		 
	 }
}
