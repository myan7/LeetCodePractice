package lc.q496_q503_q556.NextGreaterElement_I_II_III;

import java.util.Arrays;

/*
 * 556. Next Greater Element III
 * Medium
 * 
 * Given a positive 32-bit integer n, 
 * you need to find the smallest 32-bit integer 
 * which has exactly the same digits existing in the integer n 
 * and is greater in value than n. 
 * If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21

Example 2:
Input: 21
Output: -1
 */
public class NextGreaterElement_III {

	public static void main(String[] args) 
	{
		int tc1 = 12;
		int tc2 = 1; // expected: -1;
		int tc3 = 21; //expected: -1
		int tc18 = 101; // expected: 110;
		int tc27 = 12443322;//	Output:14243322	Expected:13222344
		int tc32 = 1999999999; // Output: 610065407;Expected:-1
//		System.out.println(Math.log10(tc18));
		System.out.println(nextGreaterElement(tc32));
	}
	
//	65.01%
	public static int nextGreaterElement(int n) 
	{
		long ans = 0;
		// store the integer into int array.
		int temp = n;
		int len = (int)Math.log10(n)+1;
		if(len ==1)
			return -1;
		int[] nums = new int[len];
		for(int i = len-1;i>=0;i--)
		{
			nums[i] = temp%10;
			temp =temp/10;
		}
		
		// find out the first digit that is smaller than its next one.
		int index = 0;
		for(int i = len-1;i>=0;i--)
		{
			index = i-1;
			if(index>=0 && nums[index]<nums[i])
			{
				System.out.println("index = "+ index);
					break;
			}
		}
		if(index == -1)
			return -1;
		
		// find out the smallest digit from index to the end that is larger than nums[index]
		// and then swap them.
		
		int secSwap = index+1;
		for(int i = index+1;i<len;i++)
		{
			if(nums[i]>nums[index])
			{
				secSwap = i;
			}
		}
		System.out.println("secSwap = "+ secSwap);
		int tmp = nums[index];
		nums[index] = nums[secSwap];
		nums[secSwap] = tmp;
		
		Arrays.sort(nums, index+1, len);
		for(int i = 0;i<len;i++)
		{
			System.out.print(nums[i]+" ");
		}
/*
* a the array to be sorted
	fromIndex the index of the first element, inclusive, to be sorted
	toIndex the index of the last element, exclusive, to be sorted
 */
			
		for(int i = 0; i<len;i++)
		{
			ans = ans*10 + nums[i];
		}
		
		return (ans==n || (ans >Integer.MAX_VALUE))? -1: (int)ans;
	}
}
