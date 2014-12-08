package joshua.leetcode.array;

import org.junit.Before;
import org.junit.Test;

public class MergeSortedArrayTest {

	private int[] A, B;
	private int m,n;
	
	@Before
	public  void setUp(){
		A=new int[6];
		A[0]=3;
		A[1]=6;
		B=new int[]{1,2,5,7};
		m=2;
		n=4;
	}
	
	@Test
	public void testSolution1() {
		MergeSortedArray arr=new MergeSortedArray.Solution1();
		arr.merge(A, m, B, n);
		for(int i : A){
			System.out.print(i);
		}
	}

}
