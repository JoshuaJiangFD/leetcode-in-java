package joshua.leetcode.strings;

import static org.junit.Assert.*;

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
		RevserseWords sol=new RevserseWords.Solution();
		System.out.print(sol.reverseWords(s));
	}
	

}
