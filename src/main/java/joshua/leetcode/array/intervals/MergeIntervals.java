package joshua.leetcode.array.intervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class MergeIntervals {

	/**
	 * Given a collection of intervals, merge all overlapping intervals.

		For example,
		Given [1,3],[2,6],[8,10],[15,18],
		return [1,6],[8,10],[15,18].
	 */
	 public abstract List<Interval> merge(List<Interval> intervals);
	   
	 static class Solution1 extends MergeIntervals{

		@Override
		public List<Interval> merge(List<Interval> intervals) {
			if(intervals.isEmpty())
				return intervals;
			//sort the intervals firstly
			Collections.sort(intervals, new Comparator<Interval>(){
				public int compare(Interval o1, Interval o2) {
					if(o1.start!=o2.start)
						return o1.start-o2.start;
					else
						return o1.end-o2.end;
				}
			});
			//merge the intervals
			List<Interval> result=new LinkedList<Interval>();
			boolean isFirst=true;
			int start=0,end=0;
			for(Interval interval:intervals){
				if(isFirst){
					start=interval.start;
					end=interval.end;
					isFirst=false;
					continue;
				}
				if(interval.start<=end && interval.start>=start){
					end=Math.max(end, interval.end);
				}else{
					result.add(new Interval(start,end));
					start=interval.start;
					end=interval.end;
				}
			}
			result.add(new Interval(start,end));
			return result;
		}
	 }
}
