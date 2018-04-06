package lc.q605.CanPlaceFlowers;
/*
 * 605. Can Place Flowers
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, 
where 0 means empty and 1 means not empty), and a number n, 
return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False

Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.
 * 
 */

public class CanPlaceFlowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	92.32%
	public static boolean canPlaceFlowers(int[] flowerbed, int n) 
	{
/*
 * The main idea of this problem is to conclude what can be a free spot for new plant
 * first, the spot must be empty, i.e. 0
 * second, the previous position and the next position must be 0 as well
 * 
 * there is a detail you might pay attention to
 * what if the flowerbed is like [1,0,0,0,0,1]
 * there are 4 0's in the flowerbed, but it can only hold one new plant.
 * if you determine a spot for the new plant, you need to change 0 to 1.
 */
		int count = 0;
		int prev = 0;
		int next = 0;
		for(int i =0;i<flowerbed.length;i++)
		{
			if(flowerbed[i]==0)
			{
				prev = i==0?0:flowerbed[i-1];
				next = i==flowerbed.length-1?0:flowerbed[i+1];
				if(prev ==0 && next ==0)
				{
					flowerbed[i] = 1; // change 0 to 1 so that to avoid abundant count. 
					count++;
				}
			}
		}
		return count>=n;
    }

}
