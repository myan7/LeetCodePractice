package lc.q3.longestSubString;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] count = new int[s.length()];
       int num = 1;
       int answer = 0;
       for(int i =0;i<s.length()-1;i++)
       {
    	   if(s.charAt(i)==(s.charAt(i+1)))
    	   {
    		   count[i]= 0;
    		   for(int j=i+1;j<s.length()-1;j++)
               {
                   if(s.charAt(i) == (s.charAt(j)))
                   {
                       count[i]=0;
                   }else
                   {
                	   count[i]= j;
                   }
               }
    	   }else
    	   {
    		   count[i]= num++;
    	   } 
       }
       
       for(int i =0; i<count.length;i++)
       {
    	   for(int j = i+1; j<count.length-1;j++)
    	   {
    		   if(count[i]<count[j])
    		   {
    			   answer = count[j];
    		   }else
    			   answer = count[i];
    	   }
    	   
       }
       return answer;
    }
}
