package lc.q27.removeElement;
/*
 * 27. Remove Element
 * Given an array and a value, remove all instances of that value in place 
 * and return the new length.

Do not allocate extra space for another array, 
you must do this in place with constant memory.

The order of elements can be changed. 
It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

1.Try two pointers.
2.Did you use the property of "the order of elements can be changed"?
3.What happens when the elements to remove are rare?
 * 
 */

public class RemoveElementSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int removeElement(int[] nums, int val) 
	 {
		 int count =0; // this is the slow index.
		 for(int i=0; i<nums.length;i++) // this is the fast index.
		 {
			 if(nums[i]!=val)  // find out which element is not equal to val
			 {
				 nums[count] = nums[i]; // replace the first element in the array with it
				 count++; // and then move the slow index afterwards.
			 }
		 }
		 return count;
	 }
	   

}
