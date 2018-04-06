package lc.q496_q503_q556.NextGreaterElement_I_II_III;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 496. Next Greater Element I
 * Easy
 * You are given two arrays (without duplicates) nums1 and nums2 
 * where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, 
    	you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, 
    	the next greater number for it in the second array is 3.
    For number 2 in the first array, 
    	there is no next greater number for it in the second array, so output -1.

Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, 
    	the next greater number for it in the second array is 3.
    For number 4 in the first array, 
    	there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 */
public class NextGreaterElement_I {

	public static void main(String[] args) 
	{
		int[] tc11 = {4,1,2},tc12 = {1,3,4,2};
		int[] tc21 = {2,4}, tc22 = {1,2,3,4};
		int[] tc51 = {4,1,2}, tc52 = {1,2,3,4}; // expected -1,2,3
		int[] tc71 = {3,1,5,7,9,2,6}, tc72 = {1,2,3,5,6,7,9,11}; // expected: [5,2,6,9,11,3,7]
		int[] tc91 = {2,1,3}, tc92 = {2,3,1}; // expected 3,-1,-1
		int[] ans = nextGreaterElement(tc71,tc72);
		for(int e: ans)
		{
			System.out.println(e);
		}
		
	}
	
//	78.03%
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) 
	{
	       int[] ans = new int[nums1.length];
	       Map<Integer, Integer> myMap = new HashMap<>();
	       for(int i = 0; i<nums2.length;i++)
	       {
	    	   myMap.put(nums2[i], i);
	       }
	       
	       for(int i = 0;i<nums1.length;i++)
	       {
	    	   ans[i]=-1;
	    	   int index = myMap.get(nums1[i]);
	    	   while(index<nums2.length)
	    	   {
	    		   if(nums2[index]>nums1[i])
	    		   {
	    			   ans[i] = nums2[index];
	    			   break;
	    		   }
	    		   index++;
	    	   }
	       }
	       return ans;
	}

}
