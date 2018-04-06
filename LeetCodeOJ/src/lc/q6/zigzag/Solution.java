package lc.q6.zigzag;

public class Solution {
    public String convert(String s, int numRows) {
        String ans = "";
        
    	char [][] matrix = new char[numRows][s.length()/numRows]; 
    	for(int i =0;i<=s.length();i++)
        {
        	if(i%4==0)
        	{
        		System.out.print(s.charAt(i));
        	}
        }
    	return ans;
    }
}
