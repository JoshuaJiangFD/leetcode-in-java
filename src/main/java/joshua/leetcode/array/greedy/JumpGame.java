package joshua.leetcode.array.greedy;

/**
 * 55 Jump Game 
 * @see <a href="https://leetcode.com/problems/jump-game/">leet code</a>
 * @author joy
 *
 */
public abstract class JumpGame {

	/**
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

		Each element in the array represents your maximum jump length at that position.
	
		Determine if you are able to reach the last index.
	
		For example:
		A = [2,3,1,1,4], return true.
	
		A = [3,2,1,0,4], return false.
	 * @param A
	 * @return
	 */
	public abstract boolean canJump(int[] A);

	
	static class Solution1 extends JumpGame{

		@Override
		public boolean canJump(int[] A) {
			int end=A.length-1;
			for(int i=A.length-2;i>-1;i++){
				if(A[i]+i>=end)
					end=i;
			}
			return end==0;
		}
		
	}
	
	static class Solution2 extends JumpGame{

		@Override
		public boolean canJump(int[] A) {
			if(A==null)
				return false;
			boolean[] flags=new boolean[A.length];
			flags[A.length-1]=true;//means last step can jump to last step.
			for(int i=A.length-2;i>-1;i++){
				for(int j=i+1;j<A.length;j++){
					if(flags[j]==true&&(A[j]+i>=j)){
						flags[i]=true;/*so from position i, it can reach position j, can j can jump to the end. so flags[i]=true;*/
						break;
					}
				}
			}
			return flags[0];
		}
		
	}
}
