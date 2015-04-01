package joshua.leetcode.array.binarysearch;

public abstract class SearchInRotatedSortedArray {

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		
		You are given a target value to search. If found in the array return its index, otherwise return -1.
		
		You may assume no duplicate exists in the array.
	 * @param A
	 * @param target
	 * @return
	 */
	   public abstract int search(int[] A, int target);
	   
	   static class Solution extends SearchInRotatedSortedArray{

		@Override
		public int search(int[] A, int target) {
			if(A==null||A.length==0)
				return -1;
			if(A.length==1){
				return A[0]==target?0:-1;
			}
			//find the rotated position
			int begin1=0,end1=0,begin2,end2=A.length-1;
			while(end1<A.length-1 && A[end1]<=A[end1+1])end1++;
			begin2=end1+1;
			if(end1==A.length-1)
				return binarySearch(A,begin1,end1, target);
			
			if(A[end1]<target || target< A[begin2])
				return -1;
			if(A[end1]>=target &&  target>=A[begin1])
				return binarySearch(A,begin1,end1, target);
			else 
				return binarySearch(A,begin2,end2, target);
		}
		
		private int binarySearch(int[] A,int begin,int end,int target){
			int mid=(begin+end)/2;
			if(A[mid]==target)
				return mid;
			else if(mid==end)
				return -1;
			if(A[mid]<target)
				return binarySearch(A,mid+1,end,target);
			else if(mid==begin)
				return -1;
			else 
				return binarySearch(A,begin,mid-1,target);
		}
		   
	   }
}
