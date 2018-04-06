package lc.q162.FindPeakElement;
/*
 * 162. Find Peak Element
 * Medium
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 
3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
 * 
 */
public class FindPeakElement {

	public static void main(String[] args) {
		int[] tc1 = {1,2,3}; //expected 2
	}

//	2.29%
	public static int findPeakElement(int[] nums) 
	{
//		next time you come across this peak problem, you'd better draw a picture.
		for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
	
	
	public static int findPeakElement1(int[] nums) {
	       return binarySearchPeak(nums,0,nums.length-1);
	    }
	    private static int binarySearchPeak(int[] nums, int left,int right)
	    {
	        if(left == right)
	            return left;
	        int mid = left+(right-left)/2;
	        if(nums[mid]<nums[mid+1])
	        {
	            return binarySearchPeak(nums,mid+1,right);
	        }
	        return binarySearchPeak(nums,left,mid);  // unlike traditional binary search
	        // left~mid  instead of left~mid-1
	    }
	    
	public static int findPeakElement2(int[] nums)
	{
		int left = 0,right = nums.length-1;
		while(left <right)
		{
			int mid = left+(right-left)/2;
			if(nums[mid]<nums[mid+1])
			{
				left = mid+1; 
			}else
				right = mid;
		}
		return left;
	}
}
