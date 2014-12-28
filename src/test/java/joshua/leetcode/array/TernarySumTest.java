package joshua.leetcode.array;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TernarySumTest {

	private int[] num;
	
	@Before
	public void setUp(){
//		num=new int[]{-1, 0 ,1 ,2 ,-1, -4};
		num=new int[]{0,0,0};
	}
	
	@Test
	public void testSolution1() {
		TernarySum.Solution1 solution=new TernarySum.Solution1();
		List<List<Integer>> result=solution.threeSum(num);
		for(List<Integer> res:result){
			System.out.println(res);
		}
		
	}

}
