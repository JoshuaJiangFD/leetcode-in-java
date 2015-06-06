package joshua.leetcode.array.backtracking;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SubsetsTest {

	int[] S;
	
	@Before
	public void setUp() throws Exception {
		S=new int[]{1,2,3};
	}

	@Test
	public void testSolution1() {
		Subsets sol=new Subsets.Solution1();
		List<List<Integer>> subsets=sol.subsets(S);
		for(List<Integer> subset:subsets)
			System.out.println(subset);
	}
	
	@Test
	public void testSolution2(){
		Subsets sol=new Subsets.Solution2();
		List<List<Integer>> subsets=sol.subsets(S);
		for(List<Integer> subset:subsets)
			System.out.println(subset);
	}

}
