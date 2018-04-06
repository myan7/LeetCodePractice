package lc.q628.MaximumProductofThreeNumbers;

import java.util.Arrays;

/*
 * 628. Maximum Product of Three Numbers
 * Easy
 * Given an integer array, 
 * find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] 
and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 * 
 */
public class MaximumProductofThreeNumbers {

	public static void main(String[] args) 
	{
		int[] a = {-1,-7,0,3,4,9,10};
		int[] tc1 = {1,2,3};
		int[] tc2 = {-1,-2,-3};
		System.out.println(maximumProduct(tc2));
	}

//	81.12%
	public static int maximumProduct(int[] nums) 
	{ 
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		for (int n: nums) 
		{
			if (n <= min1)
			{
				min2 = min1;
				min1 = n;
			}else if (n <= min2) 
			{     // n lies between min1 and min2
				min2 = n;
			}
			
			if(n >= max1) 
			{            // n is greater than max1, max2 and max3
				max3 = max2;
				max2 = max1;
				max1 = n;
			}else if(n >= max2) 
			{     // n lies betweeen max1 and max2
				max3 = max2;
				max2 = n;
			}else if (n >= max3) 
			{     // n lies betwen max2 and max3
				max3 = n;
			}
		}
		int res1 = min1*min2*max1;
		int res2 = max1*max2*max3;
		return Math.max(res1, res2);
    }
	
//	66.72%
	public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
