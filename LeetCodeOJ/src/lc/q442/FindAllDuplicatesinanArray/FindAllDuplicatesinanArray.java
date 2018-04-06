package lc.q442.FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 442. Find All Duplicates in an Array
 * Medium   related to 448 find all numbers disappear
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

See 645. Set Mismatch same idea

 * 
 */

public class FindAllDuplicatesinanArray {

	public static void main(String[] args) 
	{
		int[] nums = {4,3,2,7,7,8,8,9,1,2,3,5,9};
		int[] tc1 = {};
		System.out.println(findDuplicates3(nums));
	}

//	78.18%
	private static List<Integer> findDuplicates3(int[] nums)
	{
		// when find a number i, flip the number at position i-1 to negative. 
	    // if the number at position i-1 is already negative, i is the number that occurs twice.
	    
//		Notice the key sentence: "Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array)"
		 List<Integer> res = new ArrayList<>();
	        for (int i = 0; i < nums.length; ++i) {
	            int index = Math.abs(nums[i])-1;
	            if (nums[index] < 0)
	                res.add(Math.abs(index+1));
	            nums[index] = -nums[index];
	        }
	        return res;
//	        for example: int[] nums = {4,3,2,7,7,8,8,9,1,2,3,5,9}
/*i=0, index = 3, nums[3] = 7; nums[3] = -7;
 *i=1, index = 2, nums[2] = 2; nums[2] = -2;
 *i=2, index = 1, nums[1] = 3; nums[1] = -3;
 *i=3, index = 6, nums[6] = 8; nums[6] = -8;
 *i=4, index = 6, nums[6] = -8; res.add; nums[6] = 8;
 *i=5, index = 7, nums[7] = 9; nums[7] = -9;
 * 	        
 */
	        
	}	
	
//	10.01%
	private static List<Integer> findDuplicates(int[] nums ) 
	{
		List<Integer> ans = new ArrayList<Integer>();
		Set<Integer> mySet = new HashSet<Integer>();
		for(int e: nums)
		{
			if(!mySet.add(e))
			{
				ans.add(e);
			}
		}
		return ans;		
	}

//	22.78%
	private static List<Integer> findDuplicates1(int[] nums)
	{
		List<Integer> ans = new ArrayList<Integer>();
		Arrays.sort(nums);
		int prev = 0;
		int curr =1;
		while(curr<nums.length)
		{
			if(nums[curr] == nums[prev])
			{
				ans.add(nums[curr]);
				prev= curr;
				curr++;
			}else
			{
				prev++;
				curr++;
			}
		}
		return ans;
	}
	
//	21.22%
	private static List<Integer> findDuplicates2(int[] nums)
	{
		List<Integer> ans = new ArrayList<Integer>();
		
		Arrays.sort(nums);
		
		int i =0, j=1;
		while(j<nums.length)  // make sure j is not larger than nums.length
		{
			if(nums[j]-nums[i]==0) // if the difference is k, meet the condition
			{
				while(j<nums.length && nums[j]-nums[i]==0) 
				{
					j++; // since I have already sort the array, if one element meet the condition
//					I need to see if the next one still meet the condition, for example,
//					[1,1,1,1,1,2,2], k =0; once the last '1' is traversed, jump out of the loop
				}
//				then count+1;
				ans.add(nums[i]);
			}
//			since i still stay put while j is moving towards the end
//			if the difference between nums[j] and nums[i] is larger than k, which means i needs to move
			else if(nums[j]-nums[i]>0)
			{
				i++;
				if(i ==j) 
				{
					j++;
				}
			}else
			{
				j++;
			}
		}
		return ans;
	}
	

}
