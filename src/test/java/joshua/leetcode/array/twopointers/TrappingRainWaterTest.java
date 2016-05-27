package joshua.leetcode.array.twopointers;

import static org.junit.Assert.*;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TrappingRainWaterTest {

	private Map<int[], Integer> cases = Maps.newHashMap();

	@Before
	public void setUp() {
		cases.put(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
	}

	@Test
	public void testSolution2() {
		TrappingRainWater sol=new TrappingRainWater.Solution2();
		for (int[] key : cases.keySet()) {
			assertEquals((int)cases.get(key), sol.trap(key));
		}
	}

	@Test
	public void testSolution1() {
		TrappingRainWater sol=new TrappingRainWater.Solution1();
		for (int[] key : cases.keySet()) {
			assertEquals((int)cases.get(key), sol.trap(key));
		}
	}

}
