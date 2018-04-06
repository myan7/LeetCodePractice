package lc.q665.NondecreasingArray;
/*
 * 665. Non-decreasing Array
 * Easy
 * Given an array with n integers, 
 * your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 
4
 to 
1
 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].
 */

public class NondecreasingArray {

	public static void main(String[] args) 
	{
		int[] tc311 = {3,4,2,3}; // should be false
		int[] tc271 = {4,2,3}; //should be true
		int[] tc278 = {4,2,1}; // should be false;
 		int[] tc314 = {2,3,3,2,4}; // should be true
 		int[] tc323 = {3,1};
		System.out.println(checkPossibility(tc278));
	}
	
//	76.05%
	public static boolean checkPossibility(int[] nums) {
        int count = 0;
        /*
         * Since we are only allowed to modify one element, but we find the disturbance by looking 
         * the adjacent two elements if they are in descending order, which makes us have two choices:
         * either modify i-1, or modify i.
         * by modifying i, we need to make sure that nums[i-1] <= nums[i+1]
         * by modifying i-1, we need to make sure that nums[i-2]<= nums[i]
         * why? because if we want to modify one element to make the whole array increasing,
         * we need to make sure the adjacent elements of the modified one in order.
         * if they are not in increasing order, we will return false.
         */
        for(int i =1; i<nums.length;i++)
        {
        	if(nums[i-1]>nums[i])
        	{
        		count++;
        		if(!((i-2>=0 && nums[i-2]<=nums[i])|| (i+1<nums.length && nums[i+1]>=nums[i-1])|| i==1 ||i ==nums.length-1)) 
        			return false;
        	}	
        }
        return count<=1;
    }
	
//	88.32%
	public static boolean checkPossibility1(int[] nums)
	{
		 int len = nums.length, count = 0;
	        if(len<=2)
	            return true;
	        
	        for(int i = 1;i<len && count<=1;i++){
	            if(nums[i-1]>nums[i]){
	                count++;
	                if(i-2<0 || nums[i-2]<=nums[i])
	                    nums[i-1] = nums[i]; 
	                else
	                    nums[i] = nums[i-1];            
	            }
	        }
	        return count<=1;
	}

}
