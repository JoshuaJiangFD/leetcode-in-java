package joshua.leetcode.strings;
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * 
 * return the length of last word in the string.

	If the last word does not exist, return 0.
	
	Note: A word is defined as a character sequence consists of non-space characters only.
	
	For example, 
	Given s = "Hello World",
	return 5
 * 
 * @author joy
 *
 */
public class LengthOfLastWord {

     /**
      * use regular expression.
      * @param s
      * @return
      */
	 public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.trim().length() == 0)
			return 0;

		String[] subStrs = s.trim().split("\\s+");
		return subStrs[subStrs.length - 1].length();
	    }
}
