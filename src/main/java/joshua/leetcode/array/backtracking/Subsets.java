package joshua.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 78 	Subsets
 * @see <a href="https://leetcode.com/problems/subsets/">leetcode link</a>
 * @author joy
 *
 */
public abstract class Subsets {

	/**
	 *  * Given a set of distinct integers, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,3], a solution is:
		
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
	 * @param S
	 * @return
	 */
	 public abstract List<List<Integer>> subsets(int[] S);
	 
	 /**
	  *<b> bit manipulation</b><br>
	  * let N number of bits represent the array S with length N.
	  * each bit's 0 or 1 value stands for whether the corresponding element in the array is present(1) or not(0).
	  * 
	  * @author joy
	  *
	  */
	 static class Solution1 extends Subsets{

		@Override
		public List<List<Integer>> subsets(int[] S) {
			Arrays.sort(S);
			List<List<Integer>> result=new ArrayList<List<Integer>>();
			if(S==null||S.length==0)
				return result;
			int num=(int)Math.pow(2, S.length)-1;
			while(num>-1){
				List<Integer> ele=new LinkedList<Integer>();
				for(int i=0;i<=S.length-1;i++){
					if((num & (1<<i))!=0){
						ele.add(S[i]);
					}
				}
				result.add(ele);
				num--;
			}
			return result;
		}
		 
	 }
	 
	 /**
	  * <p><b>Backtracking Algorithm</b>
	  * for every element, there are two options, pick it up or not.
	  * So for every step, we keep all of the previous choices and print the whole series of selection when it meets the last element.
	  * </p>
	  * @author joy
	  *
	  */
	 static class Solution2 extends Subsets{

		@Override
		public List<List<Integer>> subsets(int[] S) {
			List<List<Integer>> result=new ArrayList<List<Integer>>();
			if(S==null||S.length==0)
				return result;
			Arrays.sort(S);
			subSetOn(0,result,new ArrayList<Integer>(),S);
			return result;
		}
		
		private void subSetOn(int idx,List<List<Integer>> result,List<Integer> choices,int[] S){
			if(idx==S.length){
				result.add(choices);
				return;
			}
			if(idx<S.length){
				List<Integer> copied_1=new ArrayList<Integer>(choices);
				copied_1.add(S[idx]);
				subSetOn(idx+1,result,copied_1,S);
				List<Integer> copied_2=new ArrayList<Integer>(choices);
				subSetOn(idx+1,result,copied_2,S);
			}
		}
		 
	 }
	 
}
