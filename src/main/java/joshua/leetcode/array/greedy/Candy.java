package joshua.leetcode.array.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 135	Candy
 * @see  <a href="https://leetcode.com/problems/candy/">leetcode link</a>
 * @author joy
 *
 */
public abstract class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating value.
	 * You are giving candies to these children subjected to the following requirements:
	 * Each child must have at least one candy.
	 * Children with a higher rating get more candies than their neighbors.
	 * What is the minimum candies you must give?
	 * 
	 * @param ratings
	 * @return
	 */
	 public abstract int candy(int[] ratings);
	 
	 /**
	  * a little verbose way.
	  * 
	  * For example: rating array: [3,2,4,3,2,1]
	  * starting from the first element on the left, we find all descending elements on its right and push into stack.
	  * for element 3, it will be (3,2), then we assign candy as 3-->2, 2-->1;
	  * but for element 4, the descending sequence will be (4,3,2,1), and we have 1-->1, 2-->2, 3-->3, for element 4.
	  * its value is decided  by maximum of left element and the descending sequence, it is Maximum of 2 and 4 as 4.
	  * so the whole candy given is [2,1,4,3,2,1].
	  * @author joy
	  *
	  */
	 static class Solution1 extends Candy{

		@Override
		public int candy(int[] ratings) {
			if (ratings == null || ratings.length == 0)
				return 0;
			int[] candies = new int[ratings.length];
			Deque<Integer> stack = new ArrayDeque<Integer>();
			for (int i = 0; i <= ratings.length; i++) {
				/*the last iteration is actually a sentinel, to flag that, we should clear all remaining items in the stack*/
				int curVal = i == ratings.length ? Integer.MAX_VALUE : ratings[i];
				if (stack.isEmpty()) {
					stack.push(i);
					continue;
				}
				int top = stack.peek();
				if (ratings[top] > curVal) {
					stack.push(i);
					continue;
				} else {
					int candy = 1;
					while (!stack.isEmpty()) {
						int topEle = stack.pop();
						if (stack.isEmpty() && topEle >= 1) {/* last element */
							if (ratings[topEle - 1] < ratings[topEle])
								candies[topEle] = Math.max(candies[topEle - 1] + 1,
										candy);
							else
								candies[topEle] = candy;
						} else
							candies[topEle] = candy++;
					}
				}
				stack.push(i);
			}
			int sum = 0;
			for (int num : candies)
				sum += num;
			return sum;
		}
		
		/**
		 * a simplified way of {@link joshua.leetcode.array.greedy.Candy.Solution1}
		 * use pointers instead of stack.
		 * @author joy
		 *
		 */
		 static class Solution2 extends Candy{

			@Override
			public int candy(int[] ratings) {
				// TODO Auto-generated method stub
				return 0;
			}}
		 
		 
	 }
}
