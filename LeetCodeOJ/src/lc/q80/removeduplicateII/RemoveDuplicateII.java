package lc.q80.removeduplicateII;

import java.util.HashSet;
import java.util.Set;

/*
 * 80. Remove Duplicates from Sorted Array II
 * Medium 
 * Follow up for "Remove Duplicates"(lc.q26):
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, 
with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
 * 
 */

public class RemoveDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates2(nums));
	}
	
	public static int removeDuplicates(int[] nums) 
	{
		if(nums.length<=2)
        {
        	return nums.length;
        }
        else
        {
        	int index =0;
        	for(int e: nums)
        	{
        		// make sure you keep the first 2 elements, so index begins at 0;
        		if(index<2 || e > nums[index-1])
        		{
        		    nums[index++]=e;
        		}
        		// what if index grows?
        		//starting at 2, if the nums[3] is no less than the previous one, 
        		// and larger than the one before the previous one.
        		else if(index>=2 && e>=nums[index-1] && e>nums[index-2])
        		{
        		    nums[index++]=e;
        		}
        		    
        	}
        	return index;
        }
    }
	
//	nums = [1,1,1,2,2,3]
	public static int removeDuplicates2(int[] nums) 
	{
		if (nums.length <= 2)
			return nums.length;
		
		int prev = 1; // pointer of the previous
		int curr = 2; // pointer of the current
 
		while (curr < nums.length) {
			if (nums[curr] == nums[prev] && nums[curr] == nums[prev - 1]) {
				curr++;
			} else {
				prev++;
				nums[prev] = nums[curr];
				curr++;
			}
		}
 
		return prev+1;
		
	}

}
