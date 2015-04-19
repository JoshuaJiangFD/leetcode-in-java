package joshua.leetcode.segmenttree;

import static org.junit.Assert.*;
import joshua.leetcode.segmenttree.SegmentTree.Function;
import joshua.leetcode.segmenttree.SegmentTree.FunctionType;

import org.junit.Before;
import org.junit.Test;

public class SegmentTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	
	/**
	 * Range sum query using SegementTree
	 */
	@Test
	public void test_SegmentTree_1() {
		int[] arr=new int[]{1,3,5,7,9,11};
		SegmentTree st=new SegmentTree(arr,FunctionType.Sum);
		assertEquals(36,st.applyRange(0, 5).value);//the sum of range(0,5), namely the whole array  is 36
		assertEquals(35,st.applyRange(1, 5).value);
		assertEquals(9,st.applyRange(0, 2).value);
		assertEquals(16,st.applyRange(0, 3).value);
	}

	/**
	 * Range minimum query using SegmentTree
	 */
	@Test
	public void test_SegmentTree_2(){
		int[] arr=new int[]{1,3,5,7,9,11};
		SegmentTree st=new SegmentTree(arr,FunctionType.Min);
		assertEquals(1,st.applyRange(0, 5).value);
		assertEquals(3,st.applyRange(1, 5).value);
		assertEquals(5,st.applyRange(2, 4).value);
		assertEquals(7,st.applyRange(3, 3).value);
	}
}
