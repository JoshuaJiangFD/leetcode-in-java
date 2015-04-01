package joshua.leetcode.testutils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUtilsTest {

	@Test
	public void testAssertArrayEquals() {
		String[] strs1=new String[]{"a","db","e"};
		String[] strs2=new String[]{"a","db","e"};
		assertEquals(true,	TestUtils.assertArrayEquals(strs1, strs2));
	}

}
