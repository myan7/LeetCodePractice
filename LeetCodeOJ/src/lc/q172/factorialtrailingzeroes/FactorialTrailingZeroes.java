package lc.q172.factorialtrailingzeroes;
/*
 * 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!. 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * 
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
    public static int trailingZeroes0(int n) 
    {
    	return n == 0 ? 0 : n / 5 + trailingZeroes0(n / 5);
//    	the whole idea of this problem is to count the times of 10.
//    	how to decide the times? 
//    	we can break 10 down into 5*2
//    	multipliers of 2 appears more times than multipliers of 5.
//    	for example: 11! : 1*2*3*4*5*6*7*8*9*10*11
//    	multipliers of 2: 2,4,6,8,10
//    	multipliers of 5: 5,10
//    	when each 2 appears, only if thereafter exists a 5, so that the number is multiplier of 10
//    	so the problem is broken down to find how many 5 are there instead of 10.
    }

}
