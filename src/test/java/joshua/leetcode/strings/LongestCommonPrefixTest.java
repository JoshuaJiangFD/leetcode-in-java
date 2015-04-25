package joshua.leetcode.strings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LongestCommonPrefixTest {


	@Test
	public void test_Solution1() {
		LongestCommonPrefix  sol=new LongestCommonPrefix.Solution1();
		String[] strs=new String[]{"",""};
		assertEquals("",sol.longestCommonPrefix(strs));
		strs=new String[]{"c","c"};
		assertEquals("c",sol.longestCommonPrefix(strs));
		strs=new String[]{"abc","ab","a"};
		assertEquals("a",sol.longestCommonPrefix(strs));
		
	}

}
