package lc.q33_q81.SearchinRotatedSortedArray_I_II;
/*
 * 81. Search in Rotated Sorted Array II
 * Medium
 * Category: Array
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
 */
public class SearchinRotatedSortedArrayII {

	public static void main(String[] args) {

	}
	
//	10.78%
	public static boolean search(int[] nums, int target) 
    {
		/*
		 * Binary search, first you need to think about what if the array is empty?
		 * what if there is only one element in the array?
		 */
		if(nums.length == 0 || nums == null)
		{
			return false;
		}
        int left = 0,right = nums.length-1;

        while(left<right)
        {
        	int mid = left+ (right-left)/2;
        	if(nums[mid] == target)
        	{
        		return true;
        	}
        	else if(nums[mid]>nums[right])
        	{
        		if(nums[left]<=target && target<nums[mid])
        			right = mid-1;
        		else
        			left = mid+1;
        	}else if(nums[mid]<nums[right])
        	{
        		if(nums[mid]<target && target <= nums[right])
        			left = mid+1;
        		else
        			right = mid-1;
        	}else
        		right--;
        }
        return target == nums[left]? true: false;  // for only one element in the array
    }

}
