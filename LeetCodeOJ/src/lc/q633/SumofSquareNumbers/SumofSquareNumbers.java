package lc.q633.SumofSquareNumbers;
/*
 * 633. Sum of Square Numbers     
 * Easy
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 * 
 */

public class SumofSquareNumbers {

	public static void main(String[] args) 
	{
		int tc1 = 50;
		int tc2 = 4;
		int tc3 = 8;
		int tc98 = 2147482647;
		long startTime = System.currentTimeMillis();
		System.out.println(judgeSquareSum3(tc98));
		long endTime = System.currentTimeMillis();
	    System.out.println("It took " + (endTime - startTime) + " milliseconds");
        System.out.println("It took " + (endTime - startTime)/1000 + " seconds");
		
	}

//	79.57% Yue's method.
	public static boolean judgeSquareSum3(int c)
	{
		int high = (int)Math.sqrt(c);  // find out the highest limit of b (a^2 +b^2 = c)
		int low = 0;
		while(high>=low)
		{
			int remain = c - high*high;   // find out the rest if high is integer
			low = (int)Math.sqrt(remain);	
			// give out the lowest limit of a, no need to start at 0 as judgeSquareSum2(int c)
//			if(low*low< remain)
//			{
//				low++;
//			}   you don't need to keep changing low, needless to say, low is determined by high.
//				Only change one factor at a time so that nothing will be missed out.
			if(low*low==remain)
			{
				return true;
			}else
			{
				high--;
			}
		}
		return false;
	}
	
	
//	the idea is correct, but it will exceed the time limit, in another word, it is a brute force method.
/*
 * 1^2 + 0^2 =	1	...+1			2^2 + 0^2 =	4	...+1
 * 1^2 + 1^2 =	2	...+3			2^2 + 1^2 =	5	...+3
 * 1^2 + 2^2 =	5	...+5			2^2 + 2^2 =	8	...+5
 * 1^2 + 3^2 =	10	...+7			2^2 + 3^2 = 13	...+7
 * 1^2 + 4^2 =	17	...+9			2^2 + 4^2 =	20	...+9
 * 1^2 + 5^2 =	26	...+11			2^2 + 5^2 =	29	...+11
 * 1^2 + 6^2 =	37	...+13			2^2 + 6^2 =	40	...+13
 * 1^2 + 7^2 =	50	...+15			2^2 + 7^2 =	53	...+15
 * 1^2 + 8^2 =	65	...+17			2^2 + 8^2 =	68 	...+17
 * 1^2 + 9^2 =	82					2^2 + 9^2 =	85
 */
	public static boolean judgeSquareSum(int c) 
	{	
		if(c==0)
			return true;
		for(int i = 1;i*i<=c;i++)
		{
			int base =i*i;
			if(c == base)
				return true;
			int dif =1;
			while(c>base)
			{
				base+=dif;
				dif +=2;
				if(c == base)
				{
					return true;
				}
			}
		}
		return false;
    }
	
	
//	Binary search  12.93% 
	public static boolean judgeSquareSum1(int c)
	{
		for (long a = 0; a * a <= c; a++) 
		{
			int b = c - (int)(a * a);
			if (binary_search(0, b, b))
				return true;
		}
    		return false;
	}
	
	public static boolean binary_search(long s, long e, int n) 
	{
		if (s > e)
			return false;
		long mid = s + (e - s) / 2;
		if (mid * mid == n)
			return true;
		if (mid * mid > n)
			return binary_search(s, mid - 1, n);
		return binary_search(mid + 1, e, n);
	}
	
	
//	46.18%
	public static boolean judgeSquareSum2(int c) 
	{
        for (long a = 0; a * a <= c; a++) 
        {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
	
}
