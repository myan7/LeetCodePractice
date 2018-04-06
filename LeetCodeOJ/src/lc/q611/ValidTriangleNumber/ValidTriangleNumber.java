package lc.q611.ValidTriangleNumber;

import java.util.Arrays;

/*
 * 611. Valid Triangle Number
 * Medium
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
 */
public class ValidTriangleNumber {

	public static void main(String[] args) {
		int[] tc1 = {1,3,3,7};
		int[] tc2 = {1,3,3,4,5,6,7};
		System.out.println(triangleNumber(tc2));
	}
	
	public static int triangleNumber(int[] nums) 
	{
		/*
		 * Simple idea, the sum of two short edges should be longer than the third one.
		 * how to count?
		 * sort first, so that no combination can be skipped.
		 * the shortest one is nums[0], the longest one is nums[i], which should start from index 2
		 * cause the middle one is between the shortest and the longest, so nums[i-1].
		 * but how can we count?
		 *  0 1 2 3 4 5 6
		 * [1,3,3,4,5,6,7]
* i=2	1,3,3 combination	1,		[0,1,2]
* i=3	1,3,4.combination	X, 		[0,2,3] 1+3<=4  left++  
* i=3	3,3,4 combination	2,		[1,2,3] 3+3>4 	right--,left<=right i++  
* i=4	1,4,5 combination	X		[0,3,4]	1+4<=5  left++
* i=4	3,4,5				4		[1,3,4]	3+4>5	right-- right-left = 2,because both 345 and 345
* i=4	3,3,5				5		[1,2,4] i++     
* i=5	1,5,6 combination	X		[0,4,5] 1+5<=6 left++
* i=5	3,5,6 combination	8		[1,4,5]	3+5>6 right--; right-left = 3 356,356,456
* i=5	3,4,6 combination	10		[1,3,5] 3+4>6 right--; right-left = 2 346,346
* i=5	1,3,6 combination	X		[1,2,5] i++
* i=6	1,6,7 combination	X		[0,5,6] 1+6<=7; left++
* i=6	3,6,7 combination	14		[1,5,6] 3+6>7; right--; right-left = 4,367,367,467,567
* i=6	3,5,7 combination	17		[1,4,6] 3+5>7;right--;right-left = 3, 357,357,457
* i=6	3,4,7 combination	X		[1,3,6] 3+4<=7; left++
* i=6	3,4,7 						[2,3,6] i++

		 * 
		 * 
		 */
		int result = 0 ;
        if(nums.length<3)
            return result;
        Arrays.sort(nums); 
        for(int i =2;i<nums.length;i++)
        {
            int left = 0,right = i-1;
            while(left<right)
            {
// sort the array first 
// to makes sure the sum of the two shorter edges is larger than the longest one
                if(nums[left]+nums[right]>nums[i]) 
                {
                    result += right -left; 
                    right--; 
// one edge is nums[left], one is nums[i], 
// the number of nums[right] means the number of the combinations.
                }else       // no matter less than or equal to the third edge, the three edges cannot build a triangle.
                {
                    left++; // if the three cannot form a triangle, move the shortest edge to the right so that it could build a triangle.
                }
            }
        }
        return result;
	}

}
