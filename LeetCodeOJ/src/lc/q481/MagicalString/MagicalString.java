package lc.q481.MagicalString;

import java.util.ArrayList;
import java.util.List;

/*
 * 481. Magical String
 * Medium
 * A magical string S consists of only '1' and '2' and obeys the following rules:

The string S is magical 
because concatenating the number of contiguous occurrences of characters '1' and '2' 
generates the string S itself.

The first few elements of string S is the following: S = "1221121221221121122……"

If we group the consecutive '1's and '2's in S, it will be:

1 22 11 2 1 22 1 22 11 2 11 22 ......

and the occurrences of '1's or '2's in each group are:

1 2	2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the S itself.

Given an integer N as input, return the number of '1's in the first N number in the magical string S.

Note: N will not exceed 100,000.

Example 1:
Input: 6
Output: 3
Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 */
public class MagicalString {

	public static void main(String[] args) 
	{

	}
	
//	5.11%
/*
 * This is not a good problem because magical string could start with 2 instead of 1
 * for example: 22112122122
 * explanation: 22 11 2 1 22 1 22 11
 * 				2  2  1 1  2 1  2 
 */
	public static int magicalString(int n) 
    {
        List<Integer> magic = new ArrayList<>();
        int index = 2;
        magic.add(1);
        magic.add(2);
        magic.add(2);
        int count = 1;
        while(magic.size()<n)
        {
        	if(magic.get(index)==2)
        	{
        		if(magic.get(magic.size()-1)==2)
        		{
        			magic.add(1);
        			count++;
        			if(magic.size()<n)
        			{
        				magic.add(1);
        				count++;
        			}
        			
        			
        		}
        		else
        		{
        			magic.add(2);
        			magic.add(2);
        		}
        	}else
        	{
        		if(magic.get(magic.size()-1)==1)
        		{
        			magic.add(2);
        		}else
        		{
        			magic.add(1);
        			count ++;
        		}
        			
        	}
        	index++;
        }
        return n==0?0: count;
    }

}
