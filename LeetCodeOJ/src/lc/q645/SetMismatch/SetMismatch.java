package lc.q645.SetMismatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 645. Set Mismatch
 * Easy
 * The set S originally contains numbers from 1 to n. But unfortunately, 
 * due to the data error, one of the numbers in the set got duplicated to another number in the set, 
 * which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. 
Your task is to firstly find the number occurs twice and then find the number that is missing. 
Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

Kinda like 442. Find All Duplicates in an Array
 */
public class SetMismatch {

	public static void main(String[] args) {

	}
	
//	53.61%
	 public static int[] findErrorNums1(int[] nums) 
	 {
	      int[] ans = new int[2];
	      for(int i = 0;i<nums.length;i++)
	      {
	          if(nums[Math.abs(nums[i])-1]<0)
	              ans[0] = Math.abs(nums[i]);
	          else
	   	        nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
	      }
	      
	      for(int i = 0 ;i<nums.length;i++)
	      {
	    	  if(nums[i]>0)
	    	  {
	    		  ans[1] = i+1;
	          }
	      }
	      return ans;
	    }
	
//	1.83%  it is slower using list to array than just use array.
	public static int[] findErrorNums(int[] nums) 
	{
		 List<Integer> ans = new ArrayList<Integer>();
	     for(int i = 0;i<nums.length;i++)
	     {
	         if(nums[Math.abs(nums[i])-1]<0)
	             ans.add(Math.abs(nums[i]));
	         else
	        	 nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
	     }
	       
	     for(int i = 0 ;i<nums.length;i++)
	     {
	    	 if(nums[i]>0)
	    	 {
	    	   ans.add(i+1);
	         }
	     }
	     return ans.stream().mapToInt(i->i).toArray();
    }

	
}
