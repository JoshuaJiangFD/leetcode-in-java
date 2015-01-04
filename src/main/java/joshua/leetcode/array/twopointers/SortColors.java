package joshua.leetcode.array.twopointers;

/**
 * <b>Name</b>:	Sort Colors</br>
 * <b>tags</b>: two pointers,sorting
 * 
 * @see <a href="https://oj.leetcode.com/problems/sort-colors/">Sort Colors</a>
 * 
 * @author joy
 *
 */
public abstract class SortColors {

	/**
	 * Given an array with n objects colored red, white or blue, 
	 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.</br>
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.</br>
	 * 
	 * 
	 * Follow up:
			A rather straight forward solution is a two-pass algorithm using counting sort.
			First, iterate the array counting number of 0's, 1's, and 2's, 
			then overwrite array with total number of 0's, then 1's and followed by 2's.
			
			Could you come up with an one-pass algorithm using only constant space?
	 * @param A
	 */
	 public abstract void sortColors(int[] A);
	 
	 static class Solution1 extends SortColors{

		@Override
		public void sortColors(int[] A) {
			if(A==null||A.length==0)
				return;
			int lastOfRed=-1,lastOfWhite=-1;
			for(int index=0;index<A.length;index++){
				int cur=A[index];
				if(cur==1){/*move the lastOfWhite one step forward.*/
					if(index-lastOfWhite>1){
						A[lastOfWhite+1]=1;
						A[index]=2;
					}
					lastOfWhite++;
				}else if(cur==0){/*update both lastOfWhite and lastOfRed*/
					if(index-lastOfWhite>1){
						A[lastOfWhite+1]=0;
						A[index]=2;
					}
					if(lastOfRed==lastOfWhite){
						lastOfRed++;
						lastOfWhite++;
					}else{
						A[++lastOfRed]=0;
						A[++lastOfWhite]=1;
					}
				}
			}
		}
		 
	 }
	
}
