package lc.q169_q229.MajorityElementI_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 169. Majority Element
 * Easy
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 */
public class MajorityElement {

	public static void main(String[] args) 
	{
		int[] tc1 = {2,1,2,1,2};
		System.out.println(majorityElement(tc1));
	}
	
//	73.40%
	 public static int majorityElement(int[] nums) 
	 {
		 int count =0;
		 int maj = nums[0];
		 for(int i=0;i<nums.length;i++)
		 {
			 if(maj == nums[i])
			 {
				 count++;
			 }else if(count ==0)
			 {
				 maj = nums[i];
			 }
			 else
			 {
				 count--;
			 }
		 }
		 
		 for(int e: nums)
		 {
			 if(maj == e)
			 {
				 count++;
			 }else if(count ==0)
			 {
				 maj = e;
			 }else
			 {
				 count--;
			 }
		 }
		 return maj;
	 }
	 
//	 42.97%
	 public static int majorityElement1(int[] nums)
	 {
		 int ans =0;
			Arrays.sort(nums);
			ans = nums[nums.length/2];
		return ans;
	 }
	 
	// Hashtable 
		public static int majorityElement3(int[] nums) {
		    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		    //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
		    int ret=0;
		    for (int num: nums) {
		        if (!myMap.containsKey(num))
		            myMap.put(num, 1);
		        else
		            myMap.put(num, myMap.get(num)+1);
		        if (myMap.get(num)>nums.length/2) {
		            ret = num;
		            break;
		        }
		    }
		    return ret;
		}

		// Bit manipulation 
		public static int majorityElement4(int[] nums) {
		    int[] bit = new int[32];
		    for (int num: nums)
		        for (int i=0; i<32; i++) 
		            if ((num>>(31-i) & 1) == 1)
		                bit[i]++;
		    int ret=0;
		    for (int i=0; i<32; i++) {
		        bit[i]=bit[i]>nums.length/2?1:0;
		        ret += bit[i]*(1<<(31-i));
		    }
		    return ret;
		}
		
		public static int majorityElement5(int[] num) {

	        int major=num[0], count = 1;
	        for(int i=1; i<num.length;i++){
	            if(count==0){
	                count++;
	                major=num[i];
	            }else if(major==num[i]){
	                count++;
	            }else count--;
	            
	        }
	        return major;
	    }

}
