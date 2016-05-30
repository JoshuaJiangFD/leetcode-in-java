package joshua.leetcode.strings;

import org.junit.Before;
import org.junit.Test;

public class RevserseWordsTest {

	String s;
	
	@Before
	public void setUp() throws Exception {
		s=" the sky is  blue ";
	}

	@Test
	public void testSolution1() {
		ReverseWords sol=new ReverseWords.Solution();
		System.out.print(sol.reverseWords(s));
	}
	

}
