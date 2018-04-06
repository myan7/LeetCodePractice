package lc.q75.SortColors;
/*
 * 75. Sort Colors
 * Medium
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:  You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, 
then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 * 
 */
public class SortColors {

	public static void main(String[] args) 
	{
		int[] tc1 = {2,1,0,0,1,2};
		int index1 = 0,index2 = tc1.length-1;
		
		sortColors1(tc1);
		for(int e:tc1)
		{
			System.out.println(e);
		}
	}

//	49.10%
	 public static void sortColors(int[] nums) 
	 {
	        int[] temp = new int[nums.length];
	        for(int i =0; i <nums.length;i++)
	        {
	        	temp[i] = nums[i];
	        }
	        
	        int idx1 = 0,idx2 = nums.length-1;
	        for(int i =0;i<nums.length;i++)
	        {
	        	if(temp[i]==2)
	        		nums[idx2--] = 2;
	        	if(temp[i] ==0)
	        		nums[idx1++] = 0;
	        }
	        for(int i = idx1;i<=idx2;i++)
	        {
	        	nums[i] =1;
	        }
	 }
	 
	 public static void sortColors1(int[] nums)
	 {
		int end = nums.length-1,beg=0;
		for(int i = 0; i <= end;i++)
		{
			while(nums[i] == 2 && i<end)
				swap(nums,i,end--);
			while(nums[i]==0 && i>beg)
				swap(nums,i,beg++);
		}
	 }
	 public static void swap(int[] nums, int a, int b)
	 {
		 nums[a] = nums[a]^nums[b];
		 nums[b] = nums[a]^nums[b];
		 nums[a] = nums[a]^nums[b];
	 }
	 
}
