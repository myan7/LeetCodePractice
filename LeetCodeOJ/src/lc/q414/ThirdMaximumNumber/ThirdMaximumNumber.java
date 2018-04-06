package lc.q414.ThirdMaximumNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 * 
 * 
 */
public class ThirdMaximumNumber {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int[] tc1 = {1,2,3};
		System.out.println(thirdMax(tc1));
	}
	
	//67.23%
	public static int thirdMax(int[] nums) 
	{
		int index = 2;
		long[] a = new long[3];
		for(int i =0;i<=index;i++)
		{
			a[i] = Long.MIN_VALUE;
		}
		// first initialize all elements as min value
		Arrays.sort(nums);
		// sort the original array.
		
		Set<Integer> myset = new HashSet<Integer>();
		
		for(int i =nums.length-1; i>=0 && index>=0; i--)
		{
			if(myset.add(nums[i])) 
			{
				a[index--] = nums[i];
			}
		}
		//from the largest element, if it is larger than its previous one, then store it in the last position
//		for example: [3,2,1] --> [1,2,3]
//		a[2] =3, a[1] =2, a[0] =1;
		return a[0]==Long.MIN_VALUE? (int)a[2]: (int)a[0];
    }

//	45.67%
	public static int thirdMax1(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
	
	
	//6.09%
	public static int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
	}
	
	
	//88.22%
	public static int thirdMax3(int[] nums)
	{
			  long max = Long.MIN_VALUE, mid = max, min = max;
/*
 * This method is very clever and succinct
 * since the problem asks for the third maximum number, we just create 3 slots to store the largest 3 numbers.
 * first initialize max, mid, and min. and assign Long.MIN_VALUE to them.
 * then traverse the int array, 
 * 	if a number larger than max is found, remove the min by pass mid to min, and pass max to mid
 *  then pass the element value to max;
 *  
 *  if a number less than max but larger than mid is found, remove min by pass mid to min, 
 *  and then pass the element value to mid, keep max
 *  
 *  if a number less than mid but larger than min is found, remove min by pass element value to min
 *  
 *  then see if min is the minimum value, if so, then return the max cause there are not enough number 
 *  if min is repalced by another number, then return min.
 * 
 */
		        
			    for (int ele : nums) {
			        if (ele > max) {
			            min = mid;
			            mid = max;
			            max = ele;
			        } else if (max > ele && ele > mid) {
			            min = mid;
			            mid = ele;
			        } else if (mid > ele && ele > min) {
			            min = ele;
			        }
			    }
			        
			    return (int)(min != Long.MIN_VALUE ? min : max);
	}
	
	
	
	
	public static int thirdMax4(int[] nums) {
	int max, mid, small, count;
    max = mid = small = Integer.MIN_VALUE;
    count = 0;  //Count how many top elements have been found.

    for( int x: nums) {
        //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
        if( x == max || x == mid ) {
            continue;
        }

        if (x > max) {
            //right shift
            small = mid;
            mid = max;

            max = x;
            count++;
        } else if( x > mid) {
            //right shift
            small = mid;

            mid = x;
            count++;
        } else if ( x >= small) { //if small duplicated, that's find, there's no shift and need to increase count.
            small = x;
            count++;
        }
    }

    //"count" is used for checking whether found top 3 maximum elements.
    if( count >= 3) { 
        return small;
    } else {
        return max;
    }
	}
	
	
}
