package lc.q15_q16._3Sum_3SumClosest;

import java.util.Arrays;

/*
 * 16. 3Sum Closest
 * Medium
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class _3SumClosest {

	public static void main(String[] args) 
	{
		int[] tc1 = {-1,2,1,-4};
		int target1 = 1;
		int[] tc63 = {1,1,1,1};
		int target63 = 4;
		int[] tc70 = {-3,-2,-5,3,-4};
		int target70 = -1; //expected -2; output -4;
		int[] tc56 = {0,2,1,-3};
		int target56 = 1; //expected 0; output 3
		int[] tc44 = {0,2,1,-3};
		int target44 = 1; //expected 0;output -1
		
		System.out.println(threeSumClosest(tc44,target44));
	}

/*	First thought sliding window.
//	not sliding window because the question asked me to find the sum 3 arbitrary elements
//	that is closest to the target.
	Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element.
	If the sum is less than target, 
	it means we have to add a larger element so next element move to the next. 
	If the sum is greater, 
	it means we have to add a smaller element so last element move to the second last element. 
	Keep doing this until the end. 
	Each time compare the difference between sum and target, 
	if it is less than minimum difference so far, then replace result with it, 
	otherwise keep iterating.
*/
//	65.54% 
	public static int threeSumClosest(int[] nums, int target) 
	{
		if(nums.length <3)
			return 0;
		if(nums.length ==3)
		{
			return nums[0]+nums[1]+nums[2];
		}
		
		Arrays.sort(nums);
		int ans = nums[0]+nums[1]+nums[nums.length-1];
		
		for(int i =0;i<nums.length-2;i++)
		{
			int left = i+1, right = nums.length-1;
			
			while(left<right)
			{
				int sum = nums[i]+nums[left]+nums[right];
				if(sum>target)
					right--;
				else if(sum<target)
					left++;
				else
					return sum;
				if(Math.abs(sum-target)<Math.abs(ans-target))
					ans = sum;
			}
			
		}
		return ans;
	}

}
