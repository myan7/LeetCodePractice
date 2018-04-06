package lc.q643.MaximumAverageSubarrayI;
/*
 * 643. Maximum Average Subarray I
 * Easy
 * Given an array consisting of n integers, 
 * find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 * 
 * 
 */

public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
		int[] tc1 = {1,12,-5,-6,50,3};
		int k1 = 4;
		int[] tc97 = {5};
		int k97 = 1;
		int[] tc99 = {0,1,1,3,3};
		int t99 = 4;
		int[] tc116 = {-1};
		int k116 = 1;
		int[] tc117 = {8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
		int k117 = 93;
//		System.out.println(findMaxAverage3(tc116,k116));
		System.out.println((double)-1);
		System.out.println(Double.MIN_VALUE>0);
		System.out.println(Double.MIN_VALUE < (double)-1);
		
	}

//	89.43%  typical sliding window problem
	public static double findMaxAverage(int[] nums, int k) 
	{
			long sum = 0;
	        for (int i = 0; i < k; i++) 
	        	sum += nums[i];
	        long max = sum;
	        
	        for (int i = k; i < nums.length; i++) {
	            sum += nums[i] - nums[i - k];
	            max = Math.max(max, sum);
	        }
	        
	        return max / 1.0 / k;
		
    }
	
//	1.28%
	public static double findMaxAverage1(int[] nums, int k)
	{
		long max = Long.MIN_VALUE;
		for(int i =0; i<=nums.length-k;i++)
		{
			long sum = 0;
			int j =0;
			while(j<k)
			{
				sum += nums[i+j];
				j++;
			}
			max = Math.max(sum, max);
		}
		return max/1.0/k;
	}
	
	 public static double findMaxAverage2(int[] nums, int k) {
	        int sum = 0;
	        for(int i = 0; i < k; i++) {
	            sum += nums[i];
	        }
	        
	        int maxSum = sum;
	        for(int i = 0, j = k; j < nums.length; i++, j++) {
	            sum = sum - nums[i] + nums[j];
	            maxSum = Math.max(sum, maxSum);
	        }
	        
	        return ((double) maxSum) / ((double) k);
	    }
	 
	 public static double findMaxAverage3(int[] nums, int k)
	 {
		 int max = Integer.MIN_VALUE;
		 // you cannot use Double.MIN_VALUE because 
		 /*
		  * The IEEE 754 format has one bit reserved for the sign and the remaining bits 
		  * representing the magnitude. 
		  * This means that it is "symmetrical" around origo 
		  * (as opposed to the Integer values, which have one more negative value). 
		  * Thus the minimum value is simply the same as the maximum value, 
		  * with the sign-bit changed, 
		  * so yes, -Double.MAX_VALUE is the smallest possible actual number 
		  * you can represent with a double.
		  */
			for(int i =0;i<=nums.length-k;i++)
			{
				int total = 0;
				int j = 0;
				while(j<k)
				{
					total += nums[i+j];
					j++;
				}
				max = Math.max(total, max);
			}
			return (double)max/(double)k;
	 }
}
