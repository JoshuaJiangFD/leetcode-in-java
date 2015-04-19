package joshua.leetcode.array.twopointers;

/**
 * 11. Container With Most Water
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">leetcode link</a>
 * @author joy
 *
 */
public abstract class ContainerWithMostWater {

	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
	 * 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * 
	 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

		Note: You may not slant the container.
	 */
	public abstract int maxArea(int[] height);
	
	static class Solution1 extends ContainerWithMostWater{

		/**
		 * simplistic way to solve the problem, calculate all the possible values and record the largest.
		 */
		@Override
		public int maxArea(int[] height) {
			int maxArea=0;
			if(height==null||height.length<=1)
				return maxArea;
			for(int i=0;i<height.length;i++)
				for(int j=1;j<height.length;j++){
					int h=Math.max(height[i], height[j]);
					maxArea=Math.max(maxArea, h*Math.abs(i-j));
				}
			return maxArea;
		}
	}
	
	/**
	 * tags: two pointers.
	 * @author joy
	 *
	 */
	static class Solution2 extends ContainerWithMostWater{
		/**
		 * set two pointers, one at the head, one at the tail.
		 * each time, find out which end should move by identify the smaller values.
		 * suppose height at head node is 5, and height at tail node is 7, then move the head node until next node larger than 5.
		 * only by this way will it be possible to find next larger area with head and tail nodes as boundaries.
		 * move head or tail until they meet. 
		 */
		@Override
		public int maxArea(int[] height) {
			int maxArea=0;
			if(height==null||height.length<=1)
				return maxArea;
			int start=0, end=height.length-1;
			boolean startSmaller=height[start]<height[end];
			maxArea=Math.min(height[start],height[end])*(end-start);
			while(start<end){
				int nextMove=startSmaller?start+1:end-1;
				if(startSmaller){
					while(nextMove<end){
						if(height[nextMove]<=height[start]){
							nextMove++;
							continue;
						}
						int newArea=Math.min(height[nextMove], height[end])*(end-nextMove);
						maxArea=Math.max(maxArea,newArea);
						start=nextMove;
						break;
					}
					if(nextMove==end)
						break;	
				}
				else{
					while(nextMove>start){
						if(height[nextMove]<=height[end]){
							nextMove--;
							continue;
						}
						int newArea=Math.min(height[nextMove], height[start])*(nextMove-start);
						maxArea=Math.max(maxArea,newArea);
						end=nextMove;
						break;
					}
					if(nextMove==start)
						break;	
				}
				startSmaller=height[start]<height[end];
			}		
			return maxArea;
		}		
	}
}
