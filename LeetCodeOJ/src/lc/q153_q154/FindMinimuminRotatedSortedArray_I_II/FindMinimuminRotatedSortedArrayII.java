package lc.q153_q154.FindMinimuminRotatedSortedArray_I_II;
/*
 * 154. Find Minimum in Rotated Sorted Array II
 * Hard
 * Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII {

	public static void main(String[] args) {

	}
	
//	6.32%
	public static int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
		for(int i = 0;i<nums.length-1;i++)
		{
			if(nums[i]<=nums[i+1])  // instead of using <, I use <= to eliminate the duplicate elements.
				continue;
			else // find the maximum number, then the next element is the minimum.
				return nums[i+1];
		}
		return nums[left];
    }
	
//	1.60%
	public static int findMin1(int[] nums)
	{
		int left = 0,right = nums.length-1;
		while(left<right)
		{
			int mid = left+(right-left)/2;
			if(nums[mid]<nums[right])
			{
				right = mid;
			}
			else if(nums[mid]>nums[right])
			{
				left = mid+1;
			}else
				right--;
		}
		return nums[left];
	}

}
