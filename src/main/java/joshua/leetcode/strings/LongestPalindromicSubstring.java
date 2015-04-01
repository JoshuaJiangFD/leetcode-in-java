package joshua.leetcode.strings;

/**
 * Given a string S, find the longest palindromic substring in S.</br>
 * 1) expanded from its center</br>
 * <b>Time Complexity</b>: o(n<sup>2</sup>), <b>space complexity</b>: o(1)</br>
 * 2) Manacher’s Algorithm</br>
 *  <b>Time Complexity</b>: o(n),<b>space complexity</b>: o(1)</br>
 * 
 * @see {@link joshua.leetcode.dp.LongestPalindromicSubstring}
 * @author joy
 *
 */
public abstract class LongestPalindromicSubstring {
	
	public abstract String longestPalindrome(String s);
	
	/**
	 * We observe that a palindrome mirrors around its center. 
	 * Therefore, a palindrome can be expanded from its center, and there are only 2N-1 such centers.

     * You might be asking why there are 2N-1 but not N centers? 
     * The reason is the center of a palindrome can be in between two letters. 
     * Such palindromes have even number of letters (such as “abba”) and its center are between the two ‘b’s.
     * 
     * @see <a href="http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html">leetcode</a>
	 * @author joy
	 *
	 */
	static class Solution1 extends LongestPalindromicSubstring{

		@Override
		public String longestPalindrome(String s) {
			if (s == null)
				return null;
			int length = s.length();
			if (length == 0)
				return null;
			int head=0,tail=0;
			int maxLeng=1;
			for(int i=1;i<2*length-2;i++){
				int len=i%2==0?1:0;
				int left=i%2==0?i/2-1:(i-1)/2;
				int right=i%2==0?i/2+1:(i+1)/2;
			    while(left>-1 && right<length && s.charAt(left)==s.charAt(right)){
			    	len+=2;
			    	left--;
			    	right++;
			    }
		    	if(maxLeng<len)
		    	{
		    		maxLeng=len;
		    		head=left<=-1?0:left+1;
		    		tail=right>=length?length-1:right-1;
		    	}
			}
			return s.substring(head, tail+1);
		}
		
	}
}
