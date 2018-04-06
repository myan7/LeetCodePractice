package lc.q300.LongestIncreasingSubsequence;

import java.util.Arrays;

/*
 * 300. Longest Increasing Subsequence
 * Medium
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, 
it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) 
	{
		int[] tc1 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] tc20 = {1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLISDP2(tc20));
	}
	
//	14.94%
    public static int lengthOfLIS(int[] nums) 
    {
    	if(nums.length==0||nums ==null)
    	{
    		return 0;
    	}
    	
    	int[] count = new int[nums.length];
    	for(int i =0;i<nums.length;i++)
    	{
    		count[i]=1;
    	}
    	
    	for(int i =1;i<nums.length;i++)
    	{
    		for(int j =0;j<i;j++)
    		{
    			if(nums[i]>nums[j])
    			{
    				if(count[j]+1>count[i])
    				count[i] = Math.max(count[i] ,count[j]+1);
    			}
    		}
    	}
    	int max = 0;
    	for(int e:count)
    	{
    		max = Math.max(e,max);
    	}
    	return max;
    }
    
//    43.78%
    public static int lengthOfLISDP(int[] nums) 
    {
    	if(nums.length==0|| nums == null)
    		return 0;
    	int[] dp = new int[nums.length];
    	int ans = 1;
    	for(int i =0;i<dp.length;i++)
    	{
    		dp[i]=1;
    	}
    	for(int i=1;i<nums.length;i++)
    	{
    		for(int j = 0;j<i;j++ )
    		{
    			if(nums[j]<nums[i])
    			{
    				dp[i] = Math.max(dp[i], dp[j]+1);
    			}
    		}
    	}
    	
    	for(int e: dp)
    	{
    		ans = Math.max(e, ans);
    	}
    	return ans;
    }
    
//    87.15%
    public static int lengthOfLISDP1(int[] nums)
    {
    	if(nums.length ==0 || nums==null)
    		return 0;
    	int[] helper = new int[nums.length];
    	int idx = 0;
    	Arrays.fill(helper, Integer.MIN_VALUE);
    	helper[0] = nums[0];
    	for(int i =1;i<nums.length;i++)
    	{
    		if(nums[i]>helper[idx])
    		{
    			idx++;
    			helper[idx]=nums[i];
    		}
    		else if(nums[i]<helper[idx])
    		{
    			int j = idx;
    			while(j>=0 && nums[i]<helper[j])
    			{
    				j--;
    			}
    			if((j>=0 && helper[j]<nums[i])|| j==-1)
    			{
    				helper[j+1] = nums[i];
    			}
    		}	
    	}
    	return idx+1;
    }
    
    public static int lengthOfLISDPNBinarySearch(int[] nums)
    {
    	 int max_idx = -1;
         for(int i = 0; i < nums.length; i++){
             int idx = BS(nums, 0, max_idx, nums[i]);
             if(idx == -1){
                 idx = ++max_idx;
             }
             nums[idx] = nums[i];
         }
         return max_idx+1;
     }

     private static int BS(int[] nums, int start, int end, int target){
         int ret = -1;
         while(start <= end){
             int mid = start + (end-start)/2;
             if(nums[mid] >= target){
                 ret = mid;
                 end = mid - 1;
             }else{
                 start = mid + 1;
             }
         }
         return ret;
    }
     
     public static int lengthOfLISDP2(int[] nums) {
         int[] dp=new int[nums.length];
         int len=0;
         for(int x:nums){
             int i=Arrays.binarySearch(dp,0,len,x);
             if(i<0) i=-(i+1);
             dp[i]=x;
             if(i==len) len++;
         }
         return len;
     }
}
