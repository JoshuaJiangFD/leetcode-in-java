package joshua.leetcode.array.twopointers;

/**
 * Trapping Rain Water 
 * 
 * @see < a href="https://leetcode.com/problems/trapping-rain-water/">leetcode link</a>
 * @author joy
 *
 */
public abstract class TrappingRainWater {

	/**
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
	 * 
	 * compute how much water it is able to trap after raining.
	 *
	 * @param height
	 * @return
	 */
	public abstract int trap(int[] height);

	/**
	 * stack, two pointers
	 * 
	 * @author joy
	 *
	 */
	public static class Solution1 extends TrappingRainWater {

		@Override
		public int trap(int[] height) {
			if (height == null || height.length <= 2)
				return 0;
			int leftIdx = 0, rightIdx = 1;
			int totalSum = 0;
			while (rightIdx < height.length) {
				int subSum = 0;
				while (rightIdx < height.length
						&& height[rightIdx] < height[leftIdx]) {
					subSum += height[leftIdx] - height[rightIdx];
					rightIdx++;
				}
				if (rightIdx < height.length) {
					totalSum += subSum;
					leftIdx = rightIdx;
					rightIdx++;
				}
			}
			/*if leftIdx==height.length-1, then we handled all the elements in array, 
			 * otherwise need to take care of the interval [leftIdx,height.Length-1]*/
			while (leftIdx < height.length) {
				int temp = leftIdx + 1;
				int sum = 0;
				while (temp < height.length && height[temp] < height[temp - 1]) {
					sum += height[leftIdx] - height[temp];
					temp++;
				}
				if (temp == height.length)
					break;
				while (temp < height.length && height[temp] >= height[temp - 1]) {
					sum += height[leftIdx] - height[temp];
					temp++;
				}
				sum -= (height[leftIdx] - height[temp - 1])
						* (temp - 1 - leftIdx);
				totalSum += sum;
				if (temp < height.length) {
					leftIdx = temp - 1;
				} else {
					break;
				}
			}
			return totalSum;
		}
	}
}
