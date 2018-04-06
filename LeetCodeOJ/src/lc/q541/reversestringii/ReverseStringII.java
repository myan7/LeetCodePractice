/*
 * 541. Reverse String II
 * Given a string and an integer k, 
 * you need to reverse the first k characters 
 * for every 2k characters counting from the start of the string. 
 * 
 * If there are less than k characters left, 
 * reverse all of them. 
 * 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original.
 * 
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * Restrictions:
 * 1. The string consists of lower English letters only.
 * 2. Length of the given string and k will in the range [1, 10000]
 * */
package lc.q541.reversestringii;

public class ReverseStringII {

	public static void main(String[] args) 
	{
		String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
		int k = 39;

		System.out.println(reverseStr(s,k));
	}
	
//	60 / 60 test cases passed.
//	Status: Accepted
//	Runtime: 15 ms
	public static String reverseStr(String s, int k) 
	{

        String ans = new String();
        int length = s.length();
        
        
        if(length<k)
        {
            StringBuffer sb = new StringBuffer(s);
            StringBuffer ansb = new StringBuffer();
        	ans = sb.reverse().toString();
        }else
        {
        	StringBuffer sb = new StringBuffer(s);
            StringBuffer ansb = new StringBuffer();
            int end = length;
          
            
        	while(end >= 2*k) // if the length is more than 2k
            {
                StringBuffer temp = new StringBuffer(sb.substring(0, k)).reverse();
        	    ansb.append(temp);
                sb = sb.delete(0, k); // remove the substring that has been appended.
            	ansb.append(sb.substring(0, k)); //just append the 2k substring
            	sb = sb.delete(0, k); // remove the substring that has been appended
            	end = sb.length(); // count the new length
            }
        	// now left string less than 2k characters
        	 if(end>=k)
             {
             	ansb.append(new StringBuffer(sb.substring(0,k)).reverse());
             	ans = ansb.toString();
             	sb = sb.delete(0, k);
             	end = sb.length();
             	ans = ansb.append(sb).toString();
             }else
                 ans = ansb.append(new StringBuffer(sb.substring(0,end)).reverse()).toString();      	
        }
        return ans;
    }
	
//	60 / 60 test cases passed.
//	Status: Accepted
//	Runtime: 9 ms
	public static String reverseStr2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

}