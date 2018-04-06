package lc.q673_q674.NumberofLongestIncreasingSubsequence_LongestContinuousIncreasingSubsequence;

import java.util.Arrays;

/*
 * 673. Number of Longest Increasing Subsequence
 * Medium
 * Given an unsorted array of integers, 
 * find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, 
and there are 5 subsequences' length is 1, so output 5.

Note: 
Length of the given array will be not exceed 2000 
and the answer is guaranteed to be fit in 32-bit signed int.

 */
public class NumberofLongestIncreasingSubsequence {

	public static void main(String[] args) 
	{
		int[] tc1 = {1,3,5,4,7}; // expected: 2;
		int[] tc2 = {2,2,2,2,2}; // expected: 5;
		int[] tc3 = {1,3,2};
		System.out.println(findNumberOfLIS(tc3));
	}

	public static int findNumberOfLIS(int[] nums) 
	{
        // I instantiate a matrix, that the first col records the maximum length,
        // and the second col record the number of the maximum length;
        int[][] matrix = new int[nums.length][2];
        
        for(int i =0;i<nums.length;i++)
        {

        	if(i==0){ // the first element is length=1 and number =1;
        		matrix[i][0] = 1;
        		matrix[i][1] = 1;
        	}
        		if(i>0)
        	{
        		for(int j =i-1;j>=0;j--)
            	{
            		if(nums[i]>nums[j] && matrix[i][0]==matrix[j][0]+1)
            		{
            			matrix[i][1] += matrix[j][1];
            		}
            		else if(nums[i]>nums[j] && matrix[i][0]<matrix[j][0]+1){
            			matrix[i][0]= matrix[j][0]+1;
            			matrix[i][1] = 1;
            		}
            		else if(nums[i]==nums[j] )
            		{
            			
            			if(matrix[i][0]==matrix[j][0])
            			{
            				matrix[i][1] += matrix[j][1];
    						break;
            			}
            			else if(matrix[i][0]<matrix[j][0])
            			{
            				matrix[i][0] = matrix[j][0];
            				matrix[i][1] = matrix[j][1];
            				break;
            			}
            			
            		}
            		
            	}
        		if(matrix[i][0]==0){
        			matrix[i][0] = 1;
        			matrix[i][1] = 1;
        		}
        	}
        }
        int[] longest = {0,0};
        for(int i = matrix.length-1;i>=0;i--){
        	if(matrix[i][0]>longest[0]){
        		longest[0] = matrix[i][0];
        		longest[1] = matrix[i][1];
        	}
        	else if(matrix[i][0] == longest[0])
        		longest[1] += matrix[i][1];
        }
        return longest[1];
        
        
    }
}
