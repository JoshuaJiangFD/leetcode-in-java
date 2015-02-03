package joshua.leetcode.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

	private String testStr1="caba";
	private String testStr2="a";
	private String testStr3="aaabaaaa";
	private String testStr4;
	private String testStr5="abcbe";
	
	@Before
	public void setUp(){
		StringBuilder sBuilder=new StringBuilder();
		for(int i=0;i<=3000;i++)
			sBuilder.append("a");
		testStr4=sBuilder.toString();
	}
	
	
	@Test
	public void testSolution1() {
		LongestPalindromicSubstring.Solution1 sol=new LongestPalindromicSubstring.Solution1();
		
//		String palindrome=sol.longestPalindrome(testStr1);
//		assertEquals("aba",palindrome);
//		String palindrome2=sol.longestPalindrome(testStr2);
//		assertEquals("a",palindrome2);		
//		String palindrome4=sol.longestPalindrome(testStr4);
//		assertEquals(testStr4,palindrome4);
		
		String palindrome4=sol.longestPalindrome(testStr5);
		assertEquals("bcb",palindrome4);
		
	}
}
