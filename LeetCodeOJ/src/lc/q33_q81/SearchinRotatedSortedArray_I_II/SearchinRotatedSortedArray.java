package lc.q33_q81.SearchinRotatedSortedArray_I_II;
/*
 * Linked from 153 154 find minimum element in rotated sorted array I and II
 * 
 * 33. Search in Rotated Sorted Array
 * Medium
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

**********************************
*next one is 81. Search in Rotated Sorted Array II
 */

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		int[] tc1= {4,5,6,7,0,1,2};
		int[] tc2 = {1};
		int[] tc3 = {2,1};
		int[] tc4 = {1,2};
		int[] tc5 = {5,1,3};
		System.out.println(search(tc5,3));
		
	}
	
	public static int search(int[] nums, int target) 
	{
		int left = 0,right = nums.length-1;
		int result = -1;
		
		while(left<=right)
		{
			int mid = left+(right-left)/2;
			if(nums[mid] == target)
				return mid;
			if(nums[left]<=nums[mid]) // the left half is increasing
			{
				if(nums[left]<=target && target<nums[mid])
					right = mid-1;
				else
					left = mid+1;
			}else
			{
				if(nums[mid]<target && target<=nums[right])
					left = mid+1;
				else
					right = mid-1;
			}
		}
		
		return -1;
	}

}
