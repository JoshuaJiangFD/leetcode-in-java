package joshua.leetcode.array;

public abstract class MajorityElement {

	/**
	 * 
	 * Given an array of size n, find the majority element.
	 * 
	 * The majority element is the element that appears more than floor(n/2)
	 * times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 * @param num
	 * @return
	 */
	public abstract int majorityElement(int[] num);

	/**
	 * solution 1:Moore voting algorithm
	 * time complexity: o(n)
	 * 
	 * @author joy
	 *
	 */
	public static class Solution1 extends MajorityElement {

		/**
		 * 
		 * 1) assume the first element is the target, the index is 0, and the count of occurrence of 1;</br>
		 * 2) go through the left elements, </br>
		 * 	   <ul>a)if the element is the same, increase the count;</ul>
		 *     <ul>b)if the element is different with the current recorded one, decrease the count;</br></ul>
		 *     <ul>c)if the count is zero, that means the scanned partition doesn't have an element 
	     *     			which takes more than half numbers of occurrences.(but may be just half number).</ul>
		 * 3)<code>idx</code> will be the index of the majority element,
		 * which should be validated if this is not guaranteed</br>
		 */
		@Override
		public int majorityElement(int[] num) {
			int idx = 0;
			int count = 1;
			//find the element with maximum likelihood.
			for (int i = 1; i < num.length; i++) {
				if (num[i] == num[idx]) {
					count++;
				} else {
					count--;
				}
				if (count == 0) {
					idx = i;
					count = 1;
				}
			}
			//validate if it's the majority element.
			count=0;
			for(int i=0;i<num.length;i++){
				if(num[i]==num[idx]){
					count++;
				}
			}
			if(count>num.length/2)
				return num[idx];
			return Integer.MIN_VALUE;
		}

	}
}
