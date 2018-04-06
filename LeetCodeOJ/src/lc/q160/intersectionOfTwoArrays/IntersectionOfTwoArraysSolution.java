package lc.q160.intersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 * 
 * 
 */
public class IntersectionOfTwoArraysSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
//	20ms  60/60 tests
	 public static int[] intersection(int[] nums1, int[] nums2) 
	 {
	      Set<Integer> aSet = new HashSet();
	      for(int e:nums1)
	      {
	    	  for(int l: nums2)
	    	  {
	    		  if(e == l)
	    			  aSet.add(e);
	    	  }
	      }
	      int[] ans = new int[aSet.size()];
	      
//	      remember this!!! how to convert a set to an array.
	      int i = 0;
	      for(Integer val : aSet)
	      {
	    	  
		    	  ans[i++]=val ;
	      }
	      return ans;
	 }
	 
//	 7ms
	 public static int[] intersection2(int[] nums1, int[] nums2) 
	 {
		 Set<Integer> numSet1 = new HashSet();
		 Set<Integer> numSet2 = new HashSet();
		 Set<Integer> numSet = new HashSet();
		 for(int e: nums1)
		 {
			 numSet1.add(e);
		 }//remove all the duplicate elements in one array.
		 for(int e: nums2)
		 {
			 numSet2.add(e);
		 }//remove all the duplicate elements in one array.
//		 make sure all the elements in each arrays appear only once.
		 for(Integer val:numSet1)
		 {
			 if(numSet2.add(val)==false) 
			 {
				 numSet.add(val);
			 }
		 }
		 int i =0;
		 int[] ans = new int[numSet.size()];
		 for(Integer val:numSet)
		 {
			 ans[i++]=val;
		 }
		 return ans;
	 }
	 
//	 7ms
	 public static int[] intersection3(int[] nums1, int[] nums2) 
	 {
	 HashSet<Integer> set = new HashSet<Integer>();
     ArrayList<Integer> res = new ArrayList<Integer>();
     //Add all elements to set from array 1
     for(int i =0; i< nums1.length; i++) set.add(nums1[i]);
     for(int j = 0; j < nums2.length; j++) {
        // If present in array 2 then add to res and remove from set 
        if(set.contains(nums2[j])) {
             res.add(nums2[j]);
             set.remove(nums2[j]);
         }
     }
     // Convert ArrayList to array
     int[] arr = new int[res.size()];
     for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
     return arr;
	 }
	
	 
// This method is not gonna work for neither intersection2arrays I or II
// because the method retainall will keep all the value that match, for example
// [1,2,3] & [2,2] ======> [2,2] which should be [2] for intersection2arraysI
// [2,2,3] & [2] ========> [2,2] which should be [2] for intersection2arrayII
	 public static int[] intersection4(int[] nums1, int[] nums2) 
	 {
		 ArrayList<Integer> list1 = new ArrayList<Integer>();
		 ArrayList<Integer> list2 = new ArrayList<Integer>();
		 
		 for(int e: nums1)
		 {
			 list1.add(e);
		 }
		 for(int e: nums2)
		 {
			 list2.add(e);
		 }
		 
		 list1.retainAll(list2);
		 int index = 0;
		 int[] ans = new int[list1.size()];
		 for(int val: list1)
		 {
			 ans[index++] = val;
		 }
		 return ans;
	 }
	 
}