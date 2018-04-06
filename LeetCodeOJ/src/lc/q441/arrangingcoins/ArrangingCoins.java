package lc.q441.arrangingcoins;
/*
 *   441. Arranging Coins
 *   You have a total of n coins that you want to form in a staircase shape, 
 *   where every k-th row must have exactly k coins.
 *   
 *   Given n, find the total number of full staircase rows that can be formed.
 *   n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 *   
 */

public class ArrangingCoins {

	public static void main(String[] args) {
		int coin = 8;
		int count = arrangeCoins1(coin);
		System.out.println(count);

	}
	
	
//	113 / 1336 test cases passed.
//	Status: Time Limit Exceeded
//	Last executed input:  	2147483647
	public static int arrangeCoins0(int n) 
	{	
		int count =0;
		int result =0;
		while(result<=n)
		{
			result += ++count;
		}
        
		return count-1;
    }
	
//	 I originally think about adding together all the numbers step by step.
//	then I notice that 1+2+3+4+...+x = n 
//	which is (x+1)*x/2 = n 
//	I want to find out what x is, so x^2 + x - 2n = 0
//	 the problem can be broken down to solve the equation
//	 using the quardratic equation x = [-b +/- sqrt(b^2 + 4ac)]/2a
//	 x = [-1 +/- sqrt(1+8n)]/2
	public static int arrangeCoins1(int n) 
	{	
		return (int) ((-1+Math.sqrt(1+8*(long)n))/2);
//		cause 8*n may be overflow, we need to cast n to be long type, which is a tricky part.
	}

}
