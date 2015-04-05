package joshua.leetcode.miscellaneous;

import java.util.Stack;


/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 

Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,

 and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, 

which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters,
 no conversion is performed.

If no valid conversion could be performed, a zero value is returned. 
If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * @author joy
 *
 */
public class StringToInteger {

	public int atoi(String str) {
		if(str==null||str.isEmpty())
			return 0;
		Boolean isNegative=null;
		Stack<Integer> nums=new Stack<Integer>();
		Boolean isWrong=false;
		int size=0;
		for(int idx=0;idx<str.length();idx++){
			char ch=str.charAt(idx);
			//parse the signal,i.e. negative or positive number
			if(isNegative==null){
				if(Character.isWhitespace(ch))
					continue;
				else if(ch=='-')
					isNegative=true;
				else if(ch=='+' || Character.isDigit(ch)){
					isNegative=false;
					if(Character.isDigit(ch)&&ch!='0'){
						nums.push(ch-48);
						size++;
					}
				/*the first non-space character is not '-' or '=' or number.*/
				}else{
					isWrong=true;
					break;
				}
			}else{
				if(Character.isDigit(ch)){
					nums.push(ch-48);
					size++;
					if(size>10){/*potential to exceed Integer.MAX and Integer.MIN*/
						break;
					}
				}
				/*any non-number character afterwards will terminate the interpretation*/
				else{
					break;
				}
			}
		}
		//sum the value up
		if(isWrong)
			return 0;
		Double sum=0.0;
		int digit=0;
		while(!nums.isEmpty()){
			sum+=Math.pow(10, digit)*nums.pop();
			digit++;
		}
		if(sum>=(Integer.MAX_VALUE+1L) && isNegative)
			return Integer.MIN_VALUE;
		if(sum>=Integer.MAX_VALUE && !isNegative)
			return Integer.MAX_VALUE;
		
		return isNegative?0-sum.intValue():sum.intValue();
	}
}
