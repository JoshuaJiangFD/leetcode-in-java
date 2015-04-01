package joshua.leetcode.bfs;


import org.junit.Before;
import org.junit.Test;

public class SurroundedRegionsTest {

	char[][] region;
	
	char[][] result;
	
	
	@Before
	public void setUp(){
		region= new char[][]{
				{'X','X','X','X'},
				{'O','O','X','O'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		result=new char[][]{
				{'X','X','X','X'},
				{'X','X','X','X'},
				{'X','X','X','X'},
				{'X','O','X','X'}
		};
	}
	
	@Test
	public void testSolution1() {
		SurroundedRegions.Solution1 solution1=new SurroundedRegions.Solution1();
		solution1.solve(region);
		SurroundedRegions.printArrays(region);
		
	}

}
