package lc.q153_q154.FindMinimuminRotatedSortedArray_I_II;
/*
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) 
	{
		int[] tc1 = {1};
		int[] tc2 = {2,1};
		int[] tc3 = {1,2};
		int[] tc5 = {2,3,1};
		System.out.println(findMin(tc5));
		
	}
	
//	2.97%
	public static int findMin(int[] nums) 
	{
		// find max, then the next element of max is min
		int left = 0,right = nums.length-1;
		for(int i = 0;i<nums.length-1;i++)
		{
			if(nums[i]<nums[i+1])
				continue;
			else // find the maximum number, then the next element is the minimum.
				return nums[i+1];
		}
		return nums[left];
	}
	
	public static int findMin1(int[] nums)
	{
		int left = 0,right = nums.length-1;
		while(left<right)
		{
			int mid = left+ (right-left)/2;
			if(nums[mid]<nums[right])
			{
				right = mid;// you must include mid because it could be the minimum element.
			}
			else if(nums[mid]>nums[right])
			{
				left = mid+1;
			}
		}
		return nums[left];
		
	}

}
