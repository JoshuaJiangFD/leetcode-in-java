package joshua.leetcode.miscellaneous;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

	@Test
	public void testAtoi() {
		StringToInteger sol=new StringToInteger();
//		assertEquals(1,sol.atoi("1"));
//		assertEquals(-1,sol.atoi("-1"));
//		assertEquals(123,sol.atoi("123"));
//		assertEquals(10,sol.atoi("    010"));
		assertEquals(-2147483648,sol.atoi("-2147483648"));
	}

}
