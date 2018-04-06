package lc.q209.MinimumSizeSubarraySum;
/*
 * 209. Minimum Size Subarray Sum
 * Meidum
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution,
try coding another solution of which the time complexity is O(n log n).
**********************************O(nlogn) still need to work on.***********************
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) 
	{
		int[] tc1 = {2,3,1,2,4,3};
		int s1 = 7; // expected 2;
		int[] tc6 = {1,4,4};
		int s6 = 4; //expected:1;
		int[] tc8 = {1,2,3,4,5};
		int s8 = 11;  //expected:3;
				
		System.out.println(minSubArrayLen(s8,tc8));
	}
	
	//TLE--> 3.08%
	public static int minSubArrayLen(int s, int[] nums) 
	{
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		
		int index = 1;
		for(int i =0;i<nums.length;i++)
		{
			sum = nums[i];
			if(sum>=s)
			{
				return 1;
			}
			while(i+index<nums.length)
			{
				sum += nums[i+index];
				if(sum<s)
				{
					index++;
				}else
				{
					minLen = Math.min(minLen, index);
					break;
				}
			}
			index = 1;
		}
		return minLen==Integer.MAX_VALUE? 0: minLen+1;
	}
	
//	64.63%  O(n)   
	public int minSubArrayLen1(int s, int[] nums) {
		if(nums.length ==0 || nums == null) 
	           return 0;
	    int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int beg = 0,end = 0;
	    while(end<nums.length)
	    {
	        sum += nums[end++];
	        while(sum>=s && end>=beg)
	        {
	            minLen = Math.min(minLen,end-beg);
	            sum-=nums[beg++];
	        }
	    }    
	    return minLen == Integer.MAX_VALUE? 0: minLen;
    }

}
