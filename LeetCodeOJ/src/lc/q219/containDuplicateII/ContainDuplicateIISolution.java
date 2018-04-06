package lc.q219.containDuplicateII;

import java.util.HashSet;
import java.util.Set;

/*
 *219. Contains Duplicate II 
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] 
 * and the absolute difference between i and j is at most k.
 */

public class ContainDuplicateIISolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {99,99};
		int k = 2; // should be true
		int[] nums1 = {-1,-1};
		int k1 = 1; // should be true
		int[] nums2 = {1,2,1};
		int k2 = 0; // should be false
		int[] nums3 = {1,2,1};
		int k3 = 1; // should be false
		int[] nums4 = {1,2,3,1,2,3};
		int k4 = 2; // should be false
		int[] nums5 = {1,0,1,1};
		int k5 = 1;
		int[] nums6 = {1,2,3,4,5,6,7,8,9,9};
		int k6 = 3;
		int[] nums7 = {1,2,3,4,5,6,7,8,9,10};
		int k7 = 15;
		System.out.println(containsNearbyDuplicate(nums, k));
		System.out.println(containsNearbyDuplicate(nums1, k1));
		System.out.println(containsNearbyDuplicate(nums2, k2));
		System.out.println(containsNearbyDuplicate(nums3, k3));
		System.out.println(containsNearbyDuplicate(nums4, k4));
		System.out.println(containsNearbyDuplicate(nums5, k5));
		System.out.println(containsNearbyDuplicate(nums6, k6));
	}

	
//  this is not gonna work, so give it up. I spent about 3 hours on this one.
//	public static boolean containsNearbyDuplicate(int[] nums, int k) 
//	{
//		boolean ans = false;
//        int start = k;
//        int end = nums.length-k;
//        if(k ==0)
//        {
//            ans = false;
//        }
//        else if(k>=nums.length/2)
//        {
//            for(int i =0; i<nums.length; i++)
//            {
//                for(int j = 0; j <nums.length;j++)
//                {
//                    if(nums[i]==nums[j] && i!=j&& Math.abs(j-i)<=k)
//        			ans = true;
//                }
//            }
//        }
//        else
//        {
//            for(int i =start;i<end;i++)
//        {
//        	for(int j =0; j<nums.length;j++)
//        	{
//        		if(nums[i]==nums[j] && i!=j && Math.abs(j-i)<=k)
//        			ans = true;
//        	}
//        }
//        }
//        
//        return ans;
//    }

//this is really a good code. the author put the restriction before the add, which means
// once the second if returns true, that must be true, because the first if was not
// executed, which means the 2 elements are within the range k.
// Once the set contains enough k elements and every time you enter the for loop,
// you have to execute the first if and then the second if.
//	which means you don't need to remove any element before there are k elements,
//	but when the element number you want to add to the set is larger than the range,
//	you have to remove the first one in the set
//	and then add a new element into the rear.
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(i > k) 
            	set.remove(nums[i-k-1]);
            		// when access this condition, the i is one more than the k
            if(!set.add(nums[i])) // if the set wants to add an element that already
            	return true;      // exists, it will return false, but it means, the array
            		              // contains duplicate elements within the k elements.
        }
        return false;
 }
	
}
