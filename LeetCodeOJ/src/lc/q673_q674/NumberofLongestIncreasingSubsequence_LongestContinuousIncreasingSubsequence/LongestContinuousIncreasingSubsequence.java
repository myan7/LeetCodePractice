package lc.q673_q674.NumberofLongestIncreasingSubsequence_LongestContinuousIncreasingSubsequence;
/*
 * 674. Longest Continuous Increasing Subsequence
 * Easy
 * Given an unsorted array of integers, 
 * find the length of longest continuous increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, 
it's not a continuous one where 5 and 7 are separated by 4. 

Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
Note: Length of the array will not exceed 10,000.
 */
public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) 
	{
		int[] tc1 = {1,3,5,4,7};
		int[] tc2 = {2,2,2,2,2};
		int[] tc23 = {1,3,5,7};
		int[] tc3 = {1,2,3,3,3,3,4,5,6};
		System.out.println(findLengthOfLCIS(tc3));
	}
	
//	36/36 7ms
    public static int findLengthOfLCIS(int[] nums) 
    {
    	if(nums.length == 0 || nums == null)
    		return 0;
    	int max = 1,len =1;
    	for(int i = 0;i<nums.length;i++)
    	{
    		if(i!=0 && nums[i]>nums[i-1])
    		{
    			len++;
    		}
    		else
    			len =1;
    		max = Math.max(len, max);
    	}
    	return max;
    }
}
