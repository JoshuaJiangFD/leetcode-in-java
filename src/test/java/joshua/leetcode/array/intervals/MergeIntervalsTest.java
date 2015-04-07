package joshua.leetcode.array.intervals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeIntervalsTest {

	@Test
	public void testSolution1() {
		MergeIntervals sol=new MergeIntervals.Solution1();
		//[1,3],[2,6],[8,10],[15,18]
		List<Interval> intervals=Arrays.asList(new Interval(1,3),new Interval(2,6),
				new Interval(8,10),new Interval(15,18));
		List<Interval> result=sol.merge(intervals);
		System.out.println(result);
	}

}
