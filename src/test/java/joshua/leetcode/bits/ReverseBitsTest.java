package joshua.leetcode.bits;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ReverseBitsTest {

	@Test
	public void testReverseBits() {
		ReverseBits sol=new ReverseBits();
				
		int out=ReverseBits.parseFromBitStr("01010101010101010101010101010101");
		assertEquals("1010101010101010101010101010101",Integer.toBinaryString(out));
		
		assertEquals("10101010101010101010101010101010",Integer.toBinaryString(sol.reverseBits(out)));
	}

}
