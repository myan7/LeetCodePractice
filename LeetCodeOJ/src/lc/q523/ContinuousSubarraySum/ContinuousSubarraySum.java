package lc.q523.ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

/*
 * 523. Continuous Subarray Sum
 * Medium
 * after 560. Subarray Sum Equals K
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size at least 2 
 * that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum {

	public static void main(String[] args) 
	{
		int[] tc74 = {0,0};
		int k74 = 0;
		System.out.println(checkSubarraySum(tc74,k74));
	}
	
	
	
//	55.62%
	public static boolean checkSubarraySum1(int[] nums, int k)
	{
		int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) 
        {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) // this is to make sure that the subarray is at least of size 2
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
	}
	
//	19.43%
	public static boolean checkSubarraySum(int[] nums, int k) 
	{
		 boolean flag = false;
	        int sum = 0;
	        if(k ==0)
	        {
	        	for(int i = 0;i<nums.length;i++)
	        	{
	        		for(int j = i+1;j<nums.length;j++)
	        		{
	        			if(nums[i] == 0 && nums[j]==0 && j-i == 1)
	        			{
	        				flag = true;
	        				return flag;
	                    }
	        		}
	        	}
	            return flag;
	        }
	        for(int i = 0; i<nums.length;i++)
	        {
	        	sum = nums[i];
	        	for(int j = i+1;j<nums.length;j++)
	        	{
	        		sum += nums[j];
	        		if(sum%k ==0)
	        		{
	        			flag = true;
	        			return flag;
	        		}
	        	}
	        }
	        return flag;
    }

}
