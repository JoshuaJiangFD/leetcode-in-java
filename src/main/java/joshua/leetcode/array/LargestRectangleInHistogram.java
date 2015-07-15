package joshua.leetcode.array;

import java.util.List;
import java.util.Stack;

import joshua.leetcode.segmenttree.SegmentTree;

/**
 * 84	Largest Rectangle in Histogram
 * @see <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">leetcode link</a>
 * @author joy
 *
 */
public abstract class LargestRectangleInHistogram {

	/**
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

		For example, a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

	    The largest rectangle is shown in the shaded area, which has area = 10 unit.
	    
	 * @param height
	 * @return
	 */
	public abstract int largestRectangleArea(int[] height);
	
	/**
	 *<p><b>Divide and Conquer + SegmentTree</b><br>
	 * The idea is to find the minimum value in given array, once we have index of the minimum value, the max area is maximum of
	 * following values:
	 * 
	 *<ul><li>a) Maximum area in left side of minimum value(Not including the min value);</li>
	 *<li> b) Maximum area in right side of minimum value(Not including the min value);</li>
	 *<li> c) Number of bars multiplied by minimum value;</li></ul>
	 *
	 *a) and b) can be calculated recursively.</br></p>
	 *
	 *<p><b>Time Complexity</b>
	 * <ul><li>a)TC to build a SegmentTree is o(n);</li>
	 *     <li>b)TC to build a search a range minimum in SegmentTree is o(log(n));</li>
	 *     <li>c)Let the time to recursively find max area be T(n). It can be written as: T(n) = o(Log(n)) + T(n-1)</li></ul>
	 * so the overall TC is: TC of building SegementTree and TC of recursively find max area, namely:<br>
	 *		<b><i>o(n)+n*o(log(n))</i><b>
	 *</p>
	 * @see <a href="http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/">explains in GeeksforGeeks</a>
	 * @see {@link joshua.leetcode.segmenttree.SegmentTree}
	 * 
	 * @author joy
	 *
	 */
	static class Solution1 extends LargestRectangleInHistogram{

		@Override
		public int largestRectangleArea(int[] height) {
			if(height==null||height.length==0)
				return 0;
			SegmentTree st=new SegmentTree(height,SegmentTree.FunctionType.Min);
			return recursivelyFindMax(st,0,height.length-1,height);
		}
		
		private int recursivelyFindMax(SegmentTree st,int start,int end,int[] height){
			if(start>end)
				return 0;
			if(start==end)
				return height[start];
			int minimumIdx=st.applyRange(start, end).index;
			int leftMax=recursivelyFindMax(st,start,minimumIdx-1,height);
			int rightMax=recursivelyFindMax(st,minimumIdx+1,end,height);
			return Math.max(Math.max(leftMax, rightMax),height[minimumIdx]*(end-start+1));
		}
		
	}
	
	/**
	 * <p><b>linear complexity, stack</b><br>
	 * For every bar 'x', we  can try to calculate the area with 'x' as the smallest bar in the rectangle.
	 * If we calculate such area for every bar and find the maximum, then the task is done.
	 * The key is for every bar 'x', find the leftmost and rightmost boundary which are no-smaller than bar 'x', name them as
	 * 'left index' and 'right index' of bar 'x'.</p>
	 * <p><b>Methodology Using Stack.</b>
	 * we traverse all bars from left to right, maintaining a stack of bars.
	 * Every bar is pushed into stack once;
	 * A bar is popped from stack only when a bar with smaller height is seen on the right.
	 * For this popped bar, we calculate the area with this bar as the smallest bar.
	 * the 'right index' is now known, the 'left index' is the index of previous item in stack(or the first item if stack is empty)</p>
	 * <p><b>The algorithm is:</b>
	 *  the stack is going to be those rectangles of which we have found the left side and the top, but still not the right side.
	 *	Clearly if we pick a new bar and it is taller than the largest on the stack, it doesn't disturb any of the 'ongoing' rectangles, and we can simply add it on the stack as well.
	 *	If on the other hand the new bar is smaller than some of those on the stack, we have found the right end-point of those, and can remove them in a while-loop before we continue.
	 * </p>
	 * @author joy
	 *
	 */
	static class Solution2 extends LargestRectangleInHistogram{

		@Override
		public int largestRectangleArea(int[] height) {
			if(height==null|height.length==0)
				return 0;
			int maxArea=0;
			Stack<Integer> stack=new Stack<Integer>();
			stack.push(0);
			for(int i=1;i<height.length;i++){
				/*calculate the max area with index 'top' as the smallest bar*/
				while(!stack.isEmpty()&&height[i]<height[stack.peek()]){
					int top=stack.pop();
					int leftIdx=stack.isEmpty()?-1:stack.peek();
					maxArea=Math.max(maxArea,height[top]*(i-leftIdx-1));
				}
				stack.push(i);
			}
			int rightIdx=height.length-1;
			while(!stack.isEmpty()){
				int top=stack.pop();
				int leftIdx=stack.isEmpty()?-1:stack.peek();
				maxArea=Math.max(maxArea, height[top]*(rightIdx-leftIdx));
			}
			return maxArea;
		}
		
	}
}
