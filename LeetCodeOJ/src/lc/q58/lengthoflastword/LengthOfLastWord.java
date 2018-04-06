package lc.q58.lengthoflastword;
/*
 * 58. Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 * 
 */


public class LengthOfLastWord {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s = "day";
		String s0 = "";
		String s1 = " ";
		String s2 = "           ";
		System.out.println(lengthOfLastWord(s2));

	}
	
	public static int lengthOfLastWord(String s) 
	{
//        split the string into String array using " " as token
        	String[] st = s.split(" ");
//        	for senario s0, which means nothing 
        	if(st.length<1) // or st.length == 0
        	{
        		return 0;
        	}
//        	for senario s1, which means there is only one space in the String, no valid word
        	else if(st.length==1)
        	{
        		return st[0].length();
        	}
//        	for the rest cases including "        " in a string.
        	else
        	{
        		return st[st.length-1].length();
        	}
    }
}
