package lc.q496_q503_q556.NextGreaterElement_I_II_III;

import java.util.HashMap;
import java.util.Map;

/*
 * 503. Next Greater Element II
 * Medium
 * Given a circular array (the next element of the last element is the first element of the array), 
 * print the Next Greater Number for every element. 
 * 
 * The Next Greater Number of a number x 
 * is the first greater number to its traversing-order next in the array, 
 * which means you could search circularly to find its next greater number. 
 * If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.


 */
public class NextGreaterElement_II {

	public static void main(String[] args) 
	{
		int[] tc1 = {1,2,1};  //2,-1,2
		int[] tc2 = {1,2,3,4,5};
		int[] tc154 = {100,1,11,1,120,111,123,1,-1,-100}; //[120,11,120,120,123,123,-1,100,100,100]
		int[] ans = nextGreaterElements(tc154);
		for(int e: ans)
		{
			System.out.print(e+" ");
		}

	}
	
//	81.16%
	public static int[] nextGreaterElements(int[] nums) 
	{
		int[] ans = new int[nums.length];
        int[] tmp = new int[2*nums.length];
        for(int i = 0; i<tmp.length;i++)
        {
        	tmp[i] = i<nums.length? nums[i]: nums[i-nums.length];
        }
        for(int i = 0; i<ans.length;i++)
        {
        	ans[i]=-1;
        	int index = i;
        	while(index<tmp.length)
        	{
        		if(tmp[index]>nums[i])
        		{
        			ans[i] = tmp[index];
        			break;
        		}
        		index++;
        	}
        }
        return ans;
    }

}
