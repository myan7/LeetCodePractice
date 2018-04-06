package lc.q303.RangeSumQueryImmutable;
/*
 * 303. Range Sum Query - Immutable
 * Easy 
 * Category : DP
 * Given an integer array nums, 
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {

	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray obj = new NumArray(nums);
		System.out.println(obj.sumRange(0, 5));
	}

}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

class NumArray {
    private int[] sum;
    
    public NumArray(int[] nums) 
    {
       
        for(int i = 1; i<nums.length;i++)
        {
            nums[i] +=nums[i-1];
        }
        this.sum = nums;
    }
    
    public int sumRange(int i, int j) 
    {
        return i==0? sum[j]:sum[j]-sum[i-1];
    }
}

