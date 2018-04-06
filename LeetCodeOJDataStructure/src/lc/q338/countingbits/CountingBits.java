package lc.q338.countingbits;

/*
 * 338. Counting Bits
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation 
 * and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
But can you do it in linear time O(n) /possibly in a single pass?

Space complexity should be O(n).

Can you do it like a boss? 
Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 * 
 */
public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3&1);
	}
	
	/*
	 * Notice the pattern is 
	 * 0: 0000 0000		0    
	 * 1: 0000 0001		1
	 * 2: 0000 0010		1
	 * 3: 0000 0011		2	
	 * 4: 0000 0100		1	
	 * 5: 0000 0101		2
	 * 6: 0000 0110		2
	 * 7: 0000 0111		3
	 * 8: 0000 1000		1
	 * 9: 0000 1001		2
	 * 10:0000 1010		2
	 * 11:0000 1011		3
	 * 12:0000 1100		2
	 * 13:0000 1101		3
	 * 14:0000 1110		3
	 * 15:0000 1111		4
	 * 16:0001 0000		1
	 * 0  -- 1
	 * 01 -- 12
	 * 0112 -- 1223
	 * 01121223 -- 12232334
	 */
	public static int[] countBits2(int num)
	{
		int[] res = new int[num+1];
		for(int i = 0; i<=num; i++)
		{
			res[i] = res[i/2]+ (i&1); // notice the & is like + or -, you need to put parentheses around the operands.
		}
		return res;
	}
	
	public static int[] countBits(int num) {
		int[] result = new int[num+1];
		for(int i=1;i<=num; i++)
		{
			result[i]= result[i>>1]+ (i&1);
		}
		return result;
	}

}
