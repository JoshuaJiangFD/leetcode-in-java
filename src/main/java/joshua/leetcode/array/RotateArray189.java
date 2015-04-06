package joshua.leetcode.array;

public abstract class RotateArray189 {

	/**
	 * Rotate an array of n elements to the right by k steps.

	   For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 */
	
	 public abstract void rotate(int[] nums, int k);

	 static class Solution1 extends RotateArray189{

		 public void swap(int[] a, int i, int j)
		 {
		     int temp = a[i];
		     a[i] = a[j];
		     a[j] = temp;
		 }

		  /**
		   * for example, array:[1,2,3,4,5,6], step=2
		   * the steps will be:
		   * [1,6,3,4,5,2], idx=1, temp=5
		   * [1,6,3,2.5.4], idx=3, temp=5
		   * [1,6,3,2,5,4], idx=(3+2)%6=5==temp, so temp=temp-1=4, idx=4, no element moved in this iteration
		   * [5,6,3,2,1,4], idx=0, temp=4
		   * [5,6,1,2,3,4], idx=2, temp=4, iteration exit.
		   */
		  public void rotate(int[] a, int k)
		  {
		     int N = a.length;
		     k = k%N;
		     int idx = N-1;
		     int temp = N-1;
		     /**
		      * every step will swap two element, within which one element gets the final position.
		      * So in total it only needs N-1 step.
		      */
		     for (int s = 0; s < N-1; s++)
		     {
		             idx = (idx+k)%N;            
		             if(temp == idx)
		             {
		                 temp = temp-1;
		                 idx = temp;
		                 continue; 
		             }
		             /*idx is now the final position of element at position temp*/
		             swap(a,temp,idx);           
		     }
		  }
	 }
	 
	 static class Solution2 extends RotateArray189{

		 /**
		  * example [1,2,3,4,5,6,7], step=3
		  * 
		  * rotate the [1,2,3,4] firstly as [4,3,2,1,5,6,7]
		  * rotate the [5,6,7] secondly as [4,3,2,1,7,6,5]
		  * rotate the whole array as [5,6,7,1,2,3,4]
		  */
		@Override
		public void rotate(int[] nums, int k) {
				k=k%nums.length;
				rotate(nums,0,nums.length-k-1);
				rotate(nums,nums.length-k,nums.length-1);
				rotate(nums,0,nums.length-1);
		}
		
		private void rotate(int[] nums, int start, int end){
			while(start<end){
				  nums[start] ^= nums[end];
	              nums[end] ^= nums[start];
	              nums[start] ^= nums[end];
	              start++;
	              end--;
			}
		}
		 
	 }
}

 