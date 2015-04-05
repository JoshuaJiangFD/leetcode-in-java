package joshua.leetcode.bits;

public class ReverseBits {

	/**
	 * Reverse bits of a given 32 bits unsigned integer.
	   For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
	   return 964176192   (represented in binary as 00111001011110000010100101000000).
	   
	 */

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		if(n==1)
			return Integer.MIN_VALUE;
		String bitStr = Integer.toBinaryString(n);
		StringBuilder sBuilder = new StringBuilder();
		for (int i = bitStr.length() - 1; i > -1; i--) {
			sBuilder.append(bitStr.substring(i, i + 1));
		}
		for (int j = 1; j <= 32 - bitStr.length(); j++)
			sBuilder.append("0");
		String outStr=sBuilder.toString();
		if(outStr.startsWith("0"))
			return Integer.parseInt(outStr, 2);
		sBuilder=new StringBuilder();
		sBuilder.append(0);
		for (int i = 1; i <32; i++) {
			sBuilder.append(outStr.substring(i, i + 1).endsWith("0")?"1":"0");
		}
		return 0-(Integer.parseInt(sBuilder.toString().trim(), 2)+1);
	}
	
	/**
	 * Parse 32-bit string into signed integer
	 * @return
	 */
	public static int parseFromBitStr(String bitStr){
		if(bitStr.startsWith("0"))
				return Integer.parseInt(bitStr, 2);
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append(0);
		for (int i = 1; i <32; i++) {
			sBuilder.append(bitStr.substring(i, i + 1)=="0"?"1":"0");
		}
		return 0-(Integer.parseInt(sBuilder.toString().trim(), 2)+1);	
	}
}
