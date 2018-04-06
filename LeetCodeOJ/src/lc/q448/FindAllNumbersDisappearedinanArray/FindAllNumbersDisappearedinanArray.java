package lc.q448.FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * 448. Find All Numbers Disappeared in an Array 
 * Easy
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */

public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) 
	{
		int[] nums = {1,1};// should return [2];
		int[] tc1 = {4,3,2,7,8,2,3,1}; // should return [5,6]
		int[] tc2 = {2,2}; //should return [1];
		int[] tc3 = {};
		
		
		System.out.println(findDisappearedNumbers2(tc1));
	}
	
//	12.06%
	public static List<Integer> findDisappearedNumbers(int[] nums) 
	{
		List<Integer> ans = new ArrayList<>();
		if(nums.length ==0)
			return ans;
		Arrays.sort(nums);
		int index = 0;
		int val = Math.max(nums[nums.length-1], nums.length);
		int key = 1;
		
		while(index<nums.length && key<=val)
		{
			if(key<nums[index])
			{
				ans.add(key);
				key++;
			}
			else if(key == nums[index]) // if the values can form a pair,move both to their previous one
			{
				key++;
				index++;
			}
			else if(key > nums[index])
			{
					index++;
			}			
		}
		while(key<=val)
		{
			ans.add(key++);
		}
		return ans;
		
/*  exceed time limit
//		first, sort the array
		Arrays.sort(nums);
//		second, remove the duplicates
		Set<Integer> mySet = new HashSet<>();
		for(int e: nums)
		{
			mySet.add(e);
		}
		
		if(nums.length ==0)
		{
			return ans;
		}
			
		
		System.out.println("meSet: "+mySet);
		int size = Math.max(nums.length, nums[nums.length-1]);
		System.out.println("the size should be: "+ size);
		for(int i = 1; i<=size;i++)
		{
			ans.add(i);
		}
		System.out.println("ans before removing:"+ans);
		
		for(int e: mySet)
		{
			ans.remove(ans.indexOf(e));
		}
		return ans;
		
		
		
	*/	
		
		
		
		
		
//		int curr = 1,prev =0;
//		int diff = 1;
//		while(curr<nums.length)
//		{
//			diff = nums[curr]-nums[prev];
//			if(diff==0)
//			{
//				if(curr==nums.length-1)
//				{
//					int num = nums[0]==1? 1:nums[prev]+1;
//					ans.add(num);
//				}else
//				{
//					prev = curr;
//					curr++;
//				}
//			}
//			else
//			{
//				while(diff>1)
//				{
//					ans.add(++nums[prev]);
//					diff--;
//				}
//				prev=curr;
//				curr++;
//			}
//		}
//		return ans;
//		
    }
	
//	32.10%  Kinda like find duplicate numbers in an array.
	public static List<Integer> findDisappearedNumbers1(int[] nums) 
	{
		 List<Integer> ret = new ArrayList<Integer>();
	        
	        for(int i = 0; i < nums.length; i++) 
	        {
	            int val = Math.abs(nums[i]) - 1;
	            if(nums[val] > 0) 
	            {
	                nums[val] = -nums[val];
	            }
	        }
/*
 * The basic idea is that 
 * we iterate through the input array and mark elements as negative 
 * using nums[nums[i] -1] = -nums[nums[i]-1]. 
 * for example: 4 3 2 7 8 2 3 1
 * when i = 0, nums[0] = 4, which indicates that number in position 3 exists, mark nums[3] as negative
 * 4, 3, 2, -7, 8, 2, 3, 1
 * when i = 1, nums[1] = 3, which indicates that number in position 2 exists, mark nums[2] as negative
 * 4, 3, -2, -7, 8, 2, 3, 1
 * when i = 2, nums[2] = 2, which indicates that number in position 1 exists, mark nums[1] as negative
 * 4, -3, -2, -7, 8, 2, 3, 1
 * when i = 3, nums[3] = 7, which indicates that number in position 6 exists, mark nums[6] as negative
 * 4, -3, -2, -7, 8, 2, -3, 1
 * when i = 4, nums[4] = 8, which indicates that number in position 7 exists, mark nums[7] as negative
 * 4, -3, -2, -7, 8, 2, -3, -1
 * when i = 5, nums[5] = 2, which indicates that number in position 1 exists, nums[1] is already negative
 * when i = 6, nums[6] = 3, which indicates that number in position 2 exists, nums[2] is already negative
 * when i = 7, nums[7] = 1, which indicates that number in position 0 exists, mark nums[0] as negative
 * -4, -3, -2, -7, 8, 2, -3, -1
 * for loop for marking is done.
 * Now go over the modified array again, any number is positive, which means its index+1 is missing.
 * In this way all the numbers that we have seen will be marked as negative. 
 * In the second iteration, if a value is not marked as negative, 
 * it implies we have never seen that index before, so just add it to the return list.
 */
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] > 0) {
	                ret.add(i+1);
	            }
	        }
	        return ret;
	}
	
	
//	25.42%
	/*
	 * The idea is simple, if nums[i] != i + 1 and nums[i] != nums[nums[i] - 1], 
	 * then we swap nums[i] with nums[nums[i] - 1], 
	 * for example, nums[0] = 4 and nums[3] = 7, 4 should be in position 3 and number in position 3
	 * is not 4, 
	 * then we swap nums[0] with nums[3]. 
	 * 
	 * So In the end the array will be sorted 
	 * and if nums[i] != i + 1, then i + 1 is missing.
	 * 
The example run as follows

[4,3,2,7,8,2,3,1]
[7,3,2,4,8,2,3,1]
[3,3,2,4,8,2,7,1]
[2,3,3,4,8,2,7,1]
[3,2,3,4,8,2,7,1]
[3,2,3,4,1,2,7,8]
[1,2,3,4,3,2,7,8]
Since every swap we put at least one number to its correct position, the time is O(n)
	 */
	public static List<Integer> findDisappearedNumbers2(int[] nums)
	{
		 for (int i = 0; i < nums.length; i++) {
	            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
	                int tmp = nums[i];
	                nums[i] = nums[tmp - 1];
	                nums[tmp - 1] = tmp;
	            }
	        }
	        List<Integer> res = new ArrayList<Integer>();
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] != i + 1) {
	                res.add(i + 1);
	            }
	        }
	        return res;
	}
	
	/* repeatedly swapping till all nums are in correct position*/
	public static List<Integer> findDisappearedNumbers3(int[] nums) {
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i=0; i<nums.length; i++){
	            int num = nums[i];
	           while(num!=nums[num-1]){
	               int temp = nums[num-1];
	               nums[num-1] = nums[i];
	               nums[i] = temp;
	              num = nums[i];
	           }
	        }
	        System.out.println(Arrays.toString(nums));
	    for(int i=0; i<nums.length; i++){
	        if(nums[i]!=i+1) list.add(i+1);
	    }
	    return list;
	}

}
