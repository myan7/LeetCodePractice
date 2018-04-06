package lc.q34.SearchforaRange;
/*
 * 34. Search for a Range 
 * Medium
 * Given an array of integers sorted in ascending order, 
 * find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * 
 */

public class SearchforaRange {

	public static void main(String[] args) 
	{
		int[] tc1 = {5,7,7,8,8,10};
		int target1 = 8;
		int[] tc2 = {1};
		int target2 = 0;
		int[] tc3 = {2,2};
		int target3 = 1;
		int[] tc4 = {1,4};
		int target4 = 4;
		int[] ans =searchRange(tc1,target1);
		for(int e: ans)
		{
			System.out.print(e+" ");
		}
	}
	
//	public static int[] searchRange(int[] nums, int target) 
//	{
//		int left = 0;
//		int right = nums.length;
//		
//		int[] ans = new int[2];
//		
//	}
	
	
//	31.59% 
	public static int[] searchRange(int[] nums, int target) 
	{
		if(nums.length==0)
		{
			int[] ans = {-1,-1};
			return ans;
		}
		int[] ans = new int[2];
		ans[0] = binarySearch1(nums,0,nums.length-1,target);
		ans[1] = binarySearch2(nums,0,nums.length-1,target);
		return ans;
    }
	
	public static int binarySearch1(int[] nums, int start, int end, int target)
	{		
		
		int left = -1;
		if(nums[end]<target || nums[start]>target)
		{
			return left;
		}
		while(start<= end)
		{
			int mid = start+ (end-start)/2;
			if(nums[mid]==target)
			{
				if(mid == 0 ||nums[mid-1]<target)
				{
					left = mid;
					return left;
				}
				else
				{
					end = mid -1;
				}
			}
			if(nums[mid]<target)
			{
				start = mid+1;
			}
			else if(nums[mid]>target)
			{
				end = mid-1;
			}
		}
		return left;
	}
	public static int binarySearch2(int[] nums, int start, int end, int target)
	{
		int right = -1;
		if(nums[end]<target || nums[start]>target)
		{
			return right;
		}
		
		while(start<= end)
		{
			int mid = start+ (end-start)/2;
			if(nums[mid]==target)
			{
				if(mid == nums.length-1||  nums[mid+1]>target )
				{
					right = mid;
					return right;
				}
				else
				{
					start = mid +1;
				}
			}
			if(nums[mid]<target)
			{
				start = mid+1;
			}
			else if(nums[mid]>target)
			{
				end = mid-1;
			}
		}
		return right;
	}

	public static int[] searchRangeYue(int[] nums, int target) 
	{
		int left = -1;
		int right = -1;
		int leftBound = 0,rightBound = nums.length -1;
		while(leftBound <= rightBound){
			left = (leftBound + rightBound)/2;
			if(nums[left] == target && (left == 0 || nums[left-1]<target))
				break;
			else if(nums[left] < target)
				leftBound = left+1;
			else
				rightBound = left -1;
		}
		leftBound = 0;
		rightBound = nums.length -1;
		while(leftBound <= rightBound){
			right = (leftBound + rightBound)/2;
			if(nums[right] == target && (right == nums.length-1 || nums[right+1]>target))
				break;
			else if(nums[right] > target)
				rightBound = right -1;
			else
				leftBound = right +1;
		}
		if(leftBound > rightBound)
			return new int[]{-1,-1};
		return new int[]{left,right};
	}
	
}
