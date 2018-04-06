package lc.q416.PartitionEqualSubsetSum;

import java.util.Arrays;
/*
 * 416. Partition Equal Subset Sum
 * Medium
 * Category: DP
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets 
 * such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
See lc.q494 Target Sum
 */

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] tc1 = {1,2,2,3};
		int[] tc2 = {2,3,3,4};
		int[] tc3 = {3,3,3,5};
		int[] tc4 = {1,1};
		int[] tc95 = {19,33,38,60,81,49,13,61,50,73,60,82,73,29,65,62,53,29,53,86,16,83,52,67,41,53,18,48,32,35,51,72,22,22,76,97,68,88,64,19,76,66,45,29,95,24,95,29,95,76,65,35,24,85,95,87,64,97,75,88,88,65,43,79,6,5,70,51,73,87,76,68,56,57,69,77,22,27,29,12,55,58,18,30,66,53,53,81,94,76,28,41,77,17,60,32,62,62,88,61};
		System.out.println(canPartition2(tc1));
	}

	public static boolean canPartition2(int[] nums)
	{
		int sum = 0;
		for(int num: nums)
		{
			sum+=num;
		}
		if(sum%2!= 0)
			return false;
		sum /=2;
		
		boolean[][] dp = new boolean[nums.length+1][sum+1];
		for(int i =0;i<nums.length+1;i++)
		{
			dp[i][0] = true;
		}
		for(int j =1;j<sum+1;j++)
		{
			dp[0][j] = false;
		}
		for(int i =1;i<nums.length+1;i++)
		{
			for(int j =1;j<sum+1;j++)
			{
				dp[i][j] = dp[i-1][j];
				if(j>=nums[i-1])
					dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
			}
		}
		return dp[nums.length][sum];
	}

	
	
	public static boolean canPartition(int[] nums) {
        int sumL = 0;
        for(int i =0;i<nums.length;i++)
        {
            sumL += nums[i];
           
        }
        if(sumL%2!= 0)
            return false;
        sumL = sumL/2;
        boolean[] dp = new boolean[sumL+1];
        dp[0]=true;
//      this means the first 0 numbers added up to 0 should be true
        for(int i = 1;i<nums.length;i++)
        {
            for(int j = sumL; j>=nums[i-1];j--)
            {
                dp[j] = dp[j]||dp[j-nums[i-1]];
            }
        }
        return dp[sumL];
    }
	
	
//	this is the correct idea of solving this problem, it solve the possibility this method took into
//	consideration contains both the sum of the consecutive subsequences 
//	and that of unconsecutive elements
//	what if {2,2,3,5,6}
//	sum/2 = 9 = 2+2+5 or 3+6
//	99.96%
	public static boolean canPartition1(int[] nums) 
	{
		Arrays.sort(nums); // actually you don't need to sort first
		int sum = 0;
        for(int i =0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        if(sum%2!= 0)
            return false;
        sum = sum/2;

        for(int i = nums.length-1;i>0;i--)
        {
        	int tmp = nums[i];
            if(tmp>sum)
                return false;
        	if(tmp == sum)
        		return true;
        	int index = i-1;
        	while(index>=0)
        	{
        		tmp+=nums[index];
        		if(tmp>sum)
        			tmp=tmp-nums[index];
        		if(tmp<sum)
        			index--;
        		else
        			return true;
        	}
        }
        return false;
	}
}
