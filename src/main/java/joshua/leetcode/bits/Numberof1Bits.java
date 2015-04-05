package joshua.leetcode.bits;

public class Numberof1Bits {

	/**
	 * Write a function that takes an unsigned integer and returns the number of ’1' bits 
	 * it has (also known as the Hamming weight).

	   For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
	   so the function should return 3.
	 * @param n
	 * @return
	 */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int num=0;
    	if(n==0)
    		return num;
    	if(n<0){
    		if(Math.abs(n%2)==1)
    			num+=1;
    		n=n>>>1;//unsigned right shift >>>, high end is replaced with 0
    	}
    	while(n>0){
    		if(n%2==1)
    			num+=1;
    		n=n/2;
    	}
    	return num;
    }
	/*
	 * java doesn't have unsigned type,for example, Java's int type has 4 bytes, representing from -2^31 to 2^31-1.
	 * if taking all 4 bytes to represent an unsigned integer, it ranges from 0 to 2^32-1.
	 * 
	 * Treating a java int-typed number as an unsigned value,means:
	 * for example -7 in java is represented as 1111 1111,1111 1111,1111 1111,1111 1001
	 * if viewing it as unsigned number, it would be: (2^32-6)
	 * 
	 * 1) Basic Knowledge Recap:(use one byte to represent a number)
	 * positive number 
	 * 7: 0000 0111(has same Source and Complement.)
	 * negative number:
	 * -7: 1000 0111(Source, with signed bit as 1)
	 * 	   1111 1000(reverse code, signed bit unchanged, number bit reversed)
	 *     1111 1001(reverse code + 1)
	 *     
	 * 2)Bit Operations In Java:
	 * right shift: high end is complemented with signed bit
	 * 7: 0000 0111  >> 1 --> 3:  0000 0011 equals: Math.floor(7.0/2)
	 * -7: 1111 1001 >> 1 --> -4:  1111 0100 equals: Math.floor(-7.0/2)
	 * 
	 * left shift: low end is complemented with 0
	 * 7: 0000 0111	<< 1 -->  14: 0000 1110 equals: 7*2
	 * -7: 1111 1001 <<1 --> -14: 1111 0010 equals: -7*2
	 * 
	 * unsigned right shift: to differentiate right shift, the high end is complemented with 0,
	 * for positive number it equals to right shift, but for negative number, it turns to be a unsigned positive number.
	 * -7: 1111 1001 >>> 1
	 *   = 0111 1100 :  124
	 */
}
