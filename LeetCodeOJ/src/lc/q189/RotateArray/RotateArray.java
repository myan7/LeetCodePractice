package lc.q189.RotateArray;

import java.util.Arrays;

/*
 * 189. Rotate Array
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
 * 
 */

public class RotateArray {
	public static void main(String[] args) {
		int[] tc1 = {1};
		int tck1 = 0;
		int[] tc2 = {1,2};
		int tck2 = 1;
		rotate1(tc1,tck1);
		rotate2(tc2,tck2);
		for(int e: tc2)
		{
			System.out.print(e+ " ");
		}
	}
	
//	O(1) extra place  14.33%
//	for example: 
//	[1,2,3,4,5,6,7]  n = 7, k =2
//	step1: [5,4,3,2,1,6,7] reverse the first n-k elements for their indices, they are   0~(n-k-1)
//	step2: [5,4,3,2,1,7,6] reverse the rest k elements, for their indices, they are (n-k)~ (n-1)
//	step3: [6,7,1,2,3,4,5]
//	[6,7,1,2,3,4,5]
			
	public static void rotate(int[] nums, int k) 
	{
		int n = nums.length;
		k = k%n;

		reverse(nums,0,n-k-1);
		reverse(nums,n-k,n-1);
		reverse(nums,0,n-1);
	}
	
	public static void reverse(int[] nums, int left, int right)
	{
		while(left<right)
		{
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = nums[left];
			left++;
			right--;
		}
	}
	
//	14.27%
	public static void rotate1(int[] nums, int k) 
	{
		   int len = nums.length;
	        k=k%len;
	        int[] temp = Arrays.copyOf(nums, nums.length);
	        for(int i = 0; i<k;i++)
	        {
	        	nums[i] = temp[len+i-k];
	        }
	        for(int i = len-1; i>=k;i--)
	        {
	        	nums[i] = temp[i-k];
	        }
    }
	
	/*
	 * [1,2,3,4,5,6,7] n = 7, k =3
	 *  0,1,2,3,4,5,6
	 * [5,6,7,1,2,3,4]
	 *  n-k+i
	 * 
	 */
//	 O(n) space O(n)
//	14.27%
	public static void rotate2(int[] nums, int k)
	{
		k = k%nums.length;
		int[] temp = new int[nums.length];
		int j =0;
// 		first copy the second half of nums to the first half of temp
//		when i<k nums[i] --> temp[i+k]
		
		 
		for(int i = 0;i<k;i++)
		{
			temp[i]=nums[nums.length-k+i];
		}
		for(int i = k;i<nums.length;i++)
		{
			temp[i] = nums[j++];
		}
		for (int i =0;i < nums.length;i++)  // 
		{
			nums[i] = temp[i];
		}
	}
}


