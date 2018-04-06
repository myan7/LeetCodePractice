package lc.q581.ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

/*
 * 581. Shortest Unsorted Continuous Subarray
 * Easy
 * Given an integer array, you need to find one continuous subarray 
 * that if you only sort this subarray in ascending order, 
 * then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order 
to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) 
	{
		int[] tc100 = {1,2,3,4};
		int[] tc115 = {1,2,3,3,3};
		int[] tc119 = {1,3,2,2,2};  //4
		System.out.println(findUnsortedSubarray2(tc119));
	}
	
//	39.23%
	public static int findUnsortedSubarray(int[] nums)
	{
		int [] copy = new int[nums.length];
		int idx =0;
		int beg = 0;
		int end = nums.length;
		for(int e: nums)
		{
			copy[idx++] = e;
		}
		Arrays.sort(nums);
		int count = 0;
		for(int i =0; i< nums.length;i++)
		{
			if(nums[i]!= copy[i])
			{
				beg = i;
				break;
			}else
			{
				beg = end;
			}
				
		}
		for(int i = nums.length-1;i>=0;i--)
		{
			if(nums[i]!= copy[i])
			{
				end = i;
				break;
			}
		}
		return beg == end? 0: end-beg+1;
	}
	
//	75.10%
	public static int findUnsortedSubarray2(int[] nums)
	{
		/*
		 * The idea is pretty simple,
		 * along with the iteration, 
		 * if the array is sorted, the maximum should be updated all the time; 
		 * the same as the minimum iterated from the end.
		 * end keeps being updated until its correct position is found
		 * while start stops being updated until the subarray before it is in order. 
		 */
		 if (nums == null || nums.length == 0) return 0;
	     int start = -1, end = -2, min = nums[nums.length - 1], max = nums[0];
	     for (int i = 0; i < nums.length; i++) 
	     {
	          max = Math.max(max, nums[i]);
	          min = Math.min(min, nums[nums.length - 1- i]);
	          if (max > nums[i]) end = i;
	          if (min < nums[nums.length - 1 - i]) start = nums.length - 1 - i;
	      }
	      return end - start + 1;
	}
	
	
	

}
