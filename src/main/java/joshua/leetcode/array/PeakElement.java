package joshua.leetcode.array;

/**
 * Peak Element </br>
 * <b>tag:</b>  array
 * @see <a href="https://oj.leetcode.com/problems/merge-sorted-array/">leetcode link</a>
 * @author Joshua.Jiang
 *
 */
public abstract class PeakElement {

	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public abstract int findPeakElement(int[] num);
	
	/**
	 * Binary search solution, Time Complexity: log(n) 
	 *
	 */
	static class Solution1 extends PeakElement {
		
		public int findPeakElement(int[] num){
			if(num==null)
				return -1;
			return findPeak(num, 0, num.length-1);
		}
		
		private int findPeak(int[] num, int startIdx, int endIdx){
			if(startIdx==endIdx)
				return startIdx;
			int mid=(startIdx+endIdx)/2;
			int cur=num[mid];
			Boolean biggerthanLeft=true,biggerThanRight=true;
			if(mid-1>-1 && cur<num[mid-1])
				biggerthanLeft=false;
			if(mid+1<=num.length && cur<num[mid+1])
				biggerThanRight=false;
			if(biggerthanLeft && biggerThanRight)
				return mid;
			
			if(biggerthanLeft)
				return findPeak(num,startIdx,mid-1);
			
			return findPeak(num,mid+1,endIdx);
		}
	}
}
