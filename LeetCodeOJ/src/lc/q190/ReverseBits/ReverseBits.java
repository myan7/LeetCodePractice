package lc.q190.ReverseBits;

import java.math.BigInteger;

/*
 * 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer lc.q7.ReverseInteger


 * 
 */
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tc1 = 1;
		BigInteger tc2 = new BigInteger("4294967295");
//		System.out.println(reverseBits((int)tc2));
	}
	
//	13.86%
	public int reverseBits1(int n) 
	{
	       int result = 0;
	       for (int i = 0; i < 32; i++) 
	       {
	            result += n & 1;
		        n >>>= 1;   // CATCH: must do unsigned shift
		        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	       }
	    return result;
	 }
	
	// you need treat n as an unsigned value
    public static int reverseBits2(int n) 
    {
       if (n == 0) 
    	   return 0;
    
       int result = 0;
       for (int i = 0; i < 32; i++) 
       {
    	   result <<= 1;
    	   if ((n & 1) == 1) 
    		   result++;
    	   n >>= 1;
       }
       return result;
    }
    /*
     * "
We first initialize result to 0. We then iterate from
0 to 31 (an integer has 32 bits). In each iteration:
We first shift result to the left by 1 bit.
Then, if the last digit of input n is 1, we add 1 to result. To
find the last digit of n, we just do: (n & 1)
Example, if n=5 (101), n&1 = 101 & 001 = 001 = 1;
however, if n = 2 (10), n&1 = 10 & 01 = 0).
Finally, we update n by shifting it to the right by 1 (n >>= 1)
At the end of the iteration, we return result.

Example, if input n = 13 (represented in binary as
0000_0000_0000_0000_0000_0000_0000_1101, the "_" is for readability),
calling reverseBits(13) should return:
1011_0000_0000_0000_0000_0000_0000_0000

Here is how our algorithm would work for input n = 13:

Initially, result = 0 = 0000_0000_0000_0000_0000_0000_0000_0000,
n = 13 = 0000_0000_0000_0000_0000_0000_0000_1101

Starting for loop:
i = 0:
result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_0000.
n&1 = 0000_0000_0000_0000_0000_0000_0000_1101 &
0000_0000_0000_0000_0000_0000_0000_0001 =
0000_0000_0000_0000_0000_0000_0000_0001 = 1
therefore result = result + 1 =
0000_0000_0000_0000_0000_0000_0000_0000 +
0000_0000_0000_0000_0000_0000_0000_0001 =
0000_0000_0000_0000_0000_0000_0000_0001 = 1
We right shift n by 1 (n >>= 1) to get:
n = 0000_0000_0000_0000_0000_0000_0000_0110.
We then go to the next iteration.

i = 1:
result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_0010;
n&1 = 0000_0000_0000_0000_0000_0000_0000_0110 &
0000_0000_0000_0000_0000_0000_0000_0001
= 0000_0000_0000_0000_0000_0000_0000_0000 = 0;
therefore we don't increment result.
We right shift n by 1 (n >>= 1) to get:
n = 0000_0000_0000_0000_0000_0000_0000_0011.
We then go to the next iteration.

i = 2:
result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_0100.
n&1 = 0000_0000_0000_0000_0000_0000_0000_0011 &
0000_0000_0000_0000_0000_0000_0000_0001 =
0000_0000_0000_0000_0000_0000_0000_0001 = 1
therefore result = result + 1 =
0000_0000_0000_0000_0000_0000_0000_0100 +
0000_0000_0000_0000_0000_0000_0000_0001 =
result = 0000_0000_0000_0000_0000_0000_0000_0101
We right shift n by 1 to get:
n = 0000_0000_0000_0000_0000_0000_0000_0001.
We then go to the next iteration.

i = 3:
result = result << 1 = 0000_0000_0000_0000_0000_0000_0000_1010.
n&1 = 0000_0000_0000_0000_0000_0000_0000_0001 &
0000_0000_0000_0000_0000_0000_0000_0001 =
0000_0000_0000_0000_0000_0000_0000_0001 = 1
therefore result = result + 1 =
= 0000_0000_0000_0000_0000_0000_0000_1011
We right shift n by 1 to get:
n = 0000_0000_0000_0000_0000_0000_0000_0000 = 0.

Now, from here to the end of the iteration, n is 0, so (n&1)
will always be 0 and and n >>=1 will not change n. The only change
will be for result <<=1, i.e. shifting result to the left by 1 digit.
Since there we have i=4 to i = 31 iterations left, this will result
in padding 28 0's to the right of result. i.e at the end, we get
result = 1011_0000_0000_0000_0000_0000_0000_0000

This is exactly what we expected to get
"


     */
	
	
//	this is immature, cause this method will exceed the limit. for example: 4294967295[111111...1111]
	public static int reverseBits(int n) 
	{
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(n));
        System.out.println(sb);
        //transfer the integer to binary form
        
        sb.reverse();
        //reverse the sb. for example:
//        if the binary value is 111001, which should be 0000...000111001,
//        once we reverse 111001 to 100111, and then attach 0's to the end, it will turn out to be reverse the bits
        int[] rev = new int[32];
        for(int i =0;i<32;i++)
        {
        	try
        	{
        		rev[i]=sb.charAt(i)-'0';
        	}catch(Exception e)
        	{
        		rev[i]=0;
        	}
        	System.out.print(rev[i]);
        }
        long result = 0;
        System.out.println();
       
        for(int e: rev)
        {
        	System.out.print(e);
        }
        System.out.println();
        
        for(int i = 31;i>=0;i--)
        {
//        	System.out.print(rev[i]+" ");
        	if(rev[i]==1)
        	{
        		result += Math.pow(2, 31-i);
        	}
        	else
        		result+=0;
        }
        return Math.abs((int)result);
    }
	

}
