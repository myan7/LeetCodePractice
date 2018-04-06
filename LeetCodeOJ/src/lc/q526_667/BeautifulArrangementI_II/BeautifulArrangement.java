package lc.q526_667.BeautifulArrangementI_II;
/*
 * 526. Beautiful Arrangement
 * Meidum
 * Suppose you have N integers from 1 to N. 
 * We define a beautiful arrangement as an array 
 * that is constructed by these N numbers successfully 
 * if one of the following is true for the ith position (1 <= i <= N) in this array:

1. The number at the ith position is divisible by i.
2. i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
N is a positive integer and will not exceed 15.
 * 
 */
public class BeautifulArrangement {

	public static void main(String[] args) 
	{
		int tc3 = 3; // answer should be 3;
		System.out.println(countArrangement(tc3));
	}
	
//	99.18%
	private static int count = 0;
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static void helper(int[] nums, int start) {
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) 
            	helper(nums, start-1);
            swap(nums,i, start);
        }
    }
	
	public static int countArrangement(int N) 
	{
		 if (N == 0) return 0;
	        int[] nums = new int[N+1];
	        for (int i = 0; i <= N; i++) nums[i] = i;
	        helper(nums, N);
	        return count;
    }

}
