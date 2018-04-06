/*
 * 198. House Robber
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is 
 * that adjacent houses have security system connected 
 * and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 

 * Given a list of non-negative integers 
 * representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight 
 * without alerting the police.
 * */

package lc.q198.houserobber;

public class HouseRobber {

	public static void main(String[] args) 
	{
		int[] test = {2,1,1,2};
		System.out.println(rob(test));
	}

/*
 * 69 / 69 test cases passed.
Status: Accepted
Runtime: 0 ms
 * */
	public static int rob(int[] nums)  // dynamic programming.
	{
        int ans = 0;
		if(nums.length==0)
        {
        	ans = 0;
        }
		else if(nums.length==1)
		{
			ans = nums[0];
		}
		else if(nums.length==2)
		{
			ans = Math.max(nums[0], nums[1]);
		}
		else
		{
			int max1 = nums[0];
			int max2 = Math.max(nums[0],nums[1]);
			for(int i = 2; i<nums.length;i++)
			{
				int max = Math.max(max1+nums[i], max2);
					max1 = max2;
					max2 = max;
			}
			ans = Math.max(max1, max2);
		}
		return ans;
    }

}
