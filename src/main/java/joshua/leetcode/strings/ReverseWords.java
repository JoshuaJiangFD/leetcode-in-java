package joshua.leetcode.strings;

/**
 * Reverse Words in a String </br>
 * 
 * @author Joshua.Jiang
 *
 */
public abstract class ReverseWords {

	/**
	 * Given an input string, reverse the string word by word.

		For example,
		Given s = "the sky is blue",
		return "blue is sky the".
		
		click to show clarification.
		
		Clarification:
		What constitutes a word?
		A sequence of non-space characters constitutes a word.
		Could the input string contain leading or trailing spaces?
		Yes. However, your reversed string should not contain leading or trailing spaces.
		How about multiple spaces between two words?
		Reduce them to a single space in the reversed string.
	 * @param s
	 * @return
	 */
	 public abstract String reverseWords(String s);
	 
	 /**
	  * easiest way: use java api 
	  * @author Joshua.Jiang
	  *
	  */
	 static class Solution extends ReverseWords {

		@Override
		public String reverseWords(String s) {
			String result = s.trim();
			String[] splits=result.split("\\s+");
			StringBuilder sBuilder=new StringBuilder();
			for(int i=0;i<splits.length;i++)
			{
				sBuilder.append(splits[splits.length-1-i]);
				if(i<splits.length-1)
					sBuilder.append(" ");
			}
			return sBuilder.toString();
		}
		 
	 }
}
