package lc.q88.MergeSortedArray;
/*
 * 88. Merge Sorted Array 
 * Easy
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * You may assume that nums1 has enough space 
 * (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 */

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Since the nums1 is set to be large enough to store m+n elements from nums1 and nums2
//  the last n elements in nums1 must be empty for me to fill in elements in nums2.
//	So, I'd better start from the last one, because it is empty.
//	44.35%
	 public static void merge(int[] nums1, int m, int[] nums2, int n) 
	 {
	       int i = m-1, j=n-1,k=m+n-1;
	       while(i>-1 && j>-1)
	       {
	    	   nums1[k--] = nums1[i]<nums2[j]? nums2[j--]: nums1[i--];
	       }
	       while(j>-1)
	       {
	    	   nums1[k--] = nums2[j--];
	       }
	 }
	 
//	 merge1 is the same as merge.  33.88%
	 public static void merge1(int[] nums1, int m, int[] nums2, int n) 
	    {
	         int index = m+n-1; // this is for merged nums1.
			 int i = m-1; // this is for nums1
			 int j = n-1; // this is for nums2
			 while(i>=0 && j>=0)
			 {
				 if(nums1[i]>nums2[j]) 
				 {
					 nums1[index] = nums1[i];  
					 i--;
				 }else
				 {
					 nums1[index]=nums2[j];
					 j--;
				 } // find out which one of the two elements from both arrays is larger and put it in the last position of nums1
				 //System.out.println("index is "+ index);
				 index--;
				 //System.out.println("After index--, index is "+index);
			 }
//	 		 System.out.println();
			 	// System.out.println(index);
			 	while(j>=0)
			 	{
			 	    nums1[index--] = nums2[j--]; 
			 	}
	    }
	 
	 public static void merge2(int[] nums1, int m, int[] nums2, int n) 
	    {
	         int length = m+n;
	         while(n > 0) 
	        	 nums1[m+n-1] = (m == 0 || nums1[m-1] < nums2[n-1]) ? nums2[--n] : nums1[--m];
	    }
}
