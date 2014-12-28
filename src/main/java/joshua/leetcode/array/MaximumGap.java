package joshua.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public abstract class MaximumGap {

	/**
	 * Given an unsorted array, find the maximum difference between the
	 * successive elements in its sorted form.
	 * 
	 * Try to solve it in linear time/space.
	 * 
	 * Return 0 if the array contains less than 2 elements.
	 * 
	 * You may assume all elements in the array are non-negative integers and
	 * fit in the 32-bit signed integer range.
	 * 
	 * @param num
	 * @return
	 */
	public abstract int maximumGap(int[] num);

	static class Solution extends MaximumGap {

		@Override
		public int maximumGap(int[] num) {
			if(num==null||num.length<=1)
				return 0;
			if(num.length==2)
				return Math.abs(num[0]-num[1]);
			//1. 1st traversal, find the max and min of the num
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for (int number : num) {
				if (max < number)
					max = number;
				if (min > number)
					min = number;
			}
			//2. divide the array into length-1 buckets,assign each element into the bucket 
			//according to gap to minimum element
			double averageGap = (max - min) * 1.0 / (num.length - 1);
			List<Bucket> buckets = new ArrayList<Bucket>(num.length - 1);
			for(int i=0;i<num.length-1;i++){
				buckets.add(new Bucket());
			}
			for (int element : num) {
				int index;
				if(element==max)
					index=buckets.size()-1;
				else
					index = (int) ((element - min) / averageGap);
				
				Bucket bucket=buckets.get(index);
				bucket.addElement(element);
			}
			//find the maximum gap
			int maxGap=Integer.MIN_VALUE;
			for(int i=0;i<buckets.size()-1;i++){
				Bucket bucket=buckets.get(i);
				if(bucket.isEmpty())
					continue;
				int j=i+1;
				Bucket nextBucket=buckets.get(j++);
				while(nextBucket.isEmpty()&&j<buckets.size()){
					nextBucket=buckets.get(j++);
				}
				int gapBetweenSuccsssiveBuckets=bucket.getGap(nextBucket);
				maxGap=Math.max(maxGap, gapBetweenSuccsssiveBuckets);		
			}
			return maxGap;
		}

		public class Bucket {
			
			public int max = Integer.MIN_VALUE;
			public int min = Integer.MAX_VALUE;
			
			public Boolean isEmpty=true;
	
			public Bucket(){
				isEmpty=true;
			}
			
			public void addElement(int value){
				isEmpty=false;
				if(max<value)
					max=value;
				if(min>value)
					min=value;
			}
			
			public int getGap(Bucket nextBucket){
				if(this.isEmpty||nextBucket.isEmpty)
					return Integer.MIN_VALUE;
				return nextBucket.min-this.max;
			}
			
			public Boolean isEmpty() {
				return isEmpty;
			}

			@Override
			public String toString() {
				return "Bucket [max=" + max + ", min=" + min + "]";
			}
			
		}

	}

}
