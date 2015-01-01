package joshua.leetcode.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

	private String testStr1="caba";
	private String testStr2="a";
	private String testStr3="aaabaaaa";
	private String testStr4;
	
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
		
		String palindrome4=sol.longestPalindrome(testStr4);
		assertEquals(testStr4,palindrome4);
		
	}
	
	@Test
	public void testSolution2() {
		LongestPalindromicSubstring.Solution2 sol=new LongestPalindromicSubstring.Solution2();
		
//		String palindrome=sol.longestPalindrome(testStr1);
//		assertEquals("aba",palindrome);
//		String palindrome2=sol.longestPalindrome(testStr2);
//		assertEquals("a",palindrome2);
//		String palindrome3=sol.longestPalindrome(testStr3);
//		assertEquals("aaabaaa",palindrome3);
		
		String palindrome4=sol.longestPalindrome(testStr4);
		assertEquals(testStr4,palindrome4);
		
	}
	
	@Test
	public void testSolution3() {
		LongestPalindromicSubstring.Solution3 sol=new LongestPalindromicSubstring.Solution3();
		
//		String palindrome=sol.longestPalindrome(testStr1);
//		assertEquals("aba",palindrome);
//		String palindrome2=sol.longestPalindrome(testStr2);
//		assertEquals("a",palindrome2);
//		String palindrome3=sol.longestPalindrome(testStr3);
//		assertEquals("aaabaaa",palindrome3);
		String palindrome4=sol.longestPalindrome(testStr4);
		assertEquals(testStr4,palindrome4);
	}

}
