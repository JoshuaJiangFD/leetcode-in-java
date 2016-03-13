package joshua.leetcode.dp;

/**
 * Given a string S, find the longest palindromic substring in S.</br>
 * Solution1: dynamic programming.</br>
 *  <b>Time Complexity</b>: o(n<sup>2</sup>), <b>space complexity</b>: o(n<sup>2</sup>)</br></br> 
 *  
 * @see {@link joshua.leetcode.strings.LongestPalindromicSubstring}
 * @author joy
 *
 */
public abstract class LongestPalindromicSubstring {

	/**
	 * Given a string S, find the longest palindromic substring in S.
	 * 
	 * You may assume that the maximum length of S is 1000,
	 * 
	 * and there exists one unique longest palindromic substring.
	 * 
	 * @param s
	 * @return
	 */
	public abstract String longestPalindrome(String s);

	/**
	 *Assume: S[i...j] is the substring
	 * of S indexed from i to j(-1&lt;i&lt;=j&lt;length). and LPS[i...j] is the length of the longest
	 * palindromic substring of S[i...j],<br>
	 * Given known LPS[i...j-1] and LPS[i+1...j], we have:
	 * <table>
	 * <tr>
	 * <td>LPS[i...j]=</td>
	 * <td>max(LPS[i...j-1],LPS[i+1...j])</td>
	 * <td>if S[i]!=S[j]</td>
	 * </tr>
	 * <tr>
	 * <td></td>
	 * <td>LPS[i+1...j-1]+2</td>
	 * <td>if S[i]==S[j] and LPS[i-1...j-1]==<b>true</b></td>
	 * </tr>
	 * </table>
	 * </br> Or we explain it in another way, LPS[i...j] is <b>true </b> if
	 * S[i...j] is palindrome,<br>
	 * Given known LPS[i...j-1] and LPS[i+1...j], we have:
	 * <table>
	 * <tr>
	 * <td>LPS[i...j]=</td>
	 * <td><b>true</b></td>
	 * <td>if S[i]==S[j] and LPS[i-1...j-1]==<b>true</b></td>
	 * </tr>
	 * <tr>
	 * <td></td>
	 * <td><b>false</b></td>
	 * <td>otherwise</td>
	 * </tr>
	 * </table>
	 * 
	 * @author joy
	 *
	 */
	public static class Solution1 extends LongestPalindromicSubstring {

		@Override
		public String longestPalindrome(String s) {
			if (s == null)
				return null;
			int length = s.length();
			if (length == 0)
				return null;
			/* indices of the longest palindrome's head and tail */
			int begin = -1, end = -1;
			int maxLength = 0;
			Boolean[][] isPalindrome = new Boolean[length][length];
			/*
			 * single character is taken as palindrome per se.
			 * isPalindrome[i,i-1] is taken as true, due to calculating
			 * isPalindrome[i-1,i]
			 */
			for (int i = 0; i < length; i++) {
				isPalindrome[i][i] = true;
				if (i > 0)
					isPalindrome[i][i - 1] = true;
			}
			begin = 0;
			end = 0;
			maxLength = 1;
			/**
			 * a bottom-up and left-right traversal calculation of isPalindrome
			 * array.
			 */
			for (int i = length - 2; i >= 0; i--) {
				for (int j = i + 1; j < length; j++) {
					if (s.charAt(i) == s.charAt(j)
							&& isPalindrome[i + 1][j - 1]) {
						isPalindrome[i][j] = true;
						if ((j - i + 1) > maxLength) {
							maxLength = j - i + 1;
							begin = i;
							end = j;
						}
					} else {
						isPalindrome[i][j] = false;
					}
				}
			}
			return s.substring(begin, end + 1);
		}
	}

	/**
	 * based on Solution1, but reduce the time of comparison.
	 * 
	 * @author joy
	 *
	 */
	static class Solution2 extends LongestPalindromicSubstring {

		@Override
		public String longestPalindrome(String s) {
			if (s == null)
				return null;
			int length = s.length();
			if (length == 0)
				return null;
			/* indices of the longest palindrome's head and tail */
			int begin = 0, end = 0;
			int maxLength = 1;
			Boolean[][] isPalindrome = new Boolean[length][length];

			for (int i = length - 2; i >= 0; i--) {
				char charI = s.charAt(i);
				for (int j = i + 1; j < length; j++) {
					if (charI == s.charAt(j)) {
						if (j == i + 1 || j == i + 2) {
							isPalindrome[i][j] = true;
						} else {
							isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
						}
						if (isPalindrome[i][j] && (j - i + 1) > maxLength) {
							maxLength = j - i + 1;
							begin = i;
							end = j;
						}
					} else
						isPalindrome[i][j] = false;
				}
			}
			return s.substring(begin, end + 1);
		}

	}

	/**
	 * Based on {@link Solution1}, but use top-buttom and right-left way to
	 * calculate the isPalindrome array</br> with the bonus that, the first
	 * palindrome will definitely be the longest and we can exit.</br>
	 * 
	 * @author joy
	 *
	 */
	static class Solution3 extends LongestPalindromicSubstring {

		private Boolean[][] isPalindrome;
		
		private String str;
		
		@Override
		public String longestPalindrome(String s) {
			if (s == null)
				return null;
			int length = s.length();
			if (length == 0)
				return null;
			/* indices of the longest palindrome's head  */
			int begin = 0;
			int maxLength = 1;
			isPalindrome = new Boolean[length][length];
			str=s;
			for (int len =length; len >= 2; len--) {
				Boolean canBreak=false;
				for (int head = 0; head < length-len+1; head++) {
					if(isPalindrome(head,head+len-1)){
						begin=head;
						maxLength=len;
						//just need to find the first longest palindrome
						canBreak=true;
						break;
					}
				}
				if(canBreak) break;
			}
			return s.substring(begin, begin+maxLength);
		}
		
		private Boolean isPalindrome(int i,int j){
			if(isPalindrome[i][j]!=null)
				return isPalindrome[i][j];
			if (str.charAt(i) != str.charAt(j))
				isPalindrome[i][j]=false;
			else{
				if(i==j-1||i==j-2)//two chars or three chars palindrome
					isPalindrome[i][j]=true;
				else{
					isPalindrome[i][j]=isPalindrome(i+1,j-1);
				}
			}
			return isPalindrome[i][j];	
		}
	}	

}
