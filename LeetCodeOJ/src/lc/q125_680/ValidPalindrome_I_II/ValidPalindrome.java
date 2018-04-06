package lc.q125_680.ValidPalindrome_I_II;

import java.util.Stack;

/*
 * 125. Valid Palindrome   Easy
 * 
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.


 */
public class ValidPalindrome {

	public static void main(String[] args) 
	{
		String testcase1 = "";
		String testcase2 = ".";
		String testcase3 = "racacar";
		String testcase4="0P";
		String testcase5 = "ab@a";
		String testcase6 = ",; W;:GlG:;l ;,"; // should be false
		String testcase7 = "ab";
		System.out.println('@'-0);
		System.out.println('9'-'0');
		System.out.println(isPalindrome3(testcase7));
	}
	 public static boolean isPalindrome(String s) 
	 {
		 String ls = s.toLowerCase();
		 StringBuffer sb = new StringBuffer();
		 Stack<Character> st = new Stack<Character>();
		 boolean res = false;
		 if(s.length()<1)
			 return res;
		 try{
			 for(char e:ls.toCharArray())
			 {
				 if(e>96 && e<123)
				 {
					 sb.append(e);
					 st.push(e);
				 }
			 }
			 for(char e:st.toString().toCharArray())
			 {
				 if(e == st.pop())
				 {
					 res = true;
				 }
				 else
				 {
					 res = false;
				 }
			 }
		 }catch(Exception e)
		 {
			 System.out.println(e.toString());
		 }
		 
		 return res;
	 }
	 
//	 21.82%
	 public static boolean isPalindrome1(String s) 
	 {
		 String ls = s.toLowerCase();
		 StringBuffer sb = new StringBuffer();
		 boolean res = false;
		 for(char e:ls.toCharArray())
		 {
			 if((e-'0'>=0 && e-'0'<=9)||(e>96 && e<123))
			 {
				 sb.append(e);
			 }
		 } // remove all the illegal character.
		 
		 int start = 0;
		 int end = sb.length()-1;
		 if(sb.length()<2)
		 {
			 res = true;
		 }
		 else
		 {
			 while(start < end)
			 {
				 if(sb.charAt(start++) == sb.charAt(end--))
				 {
					 res = true;
				 }
				 else
				 {
					 res = false;
					 return res;
				 }
			 }
		 }
		 return res;
	 }
	 
//	 8.49%
	 public static boolean isPalindrome2(String s)
	 {
		 	String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	        String rev = new StringBuffer(actual).reverse().toString();
	        return actual.equals(rev);
	 }
	 
//	 30.13%
	 public static boolean isPalindrome3(String s)
	 {
		 String ls = s.toLowerCase();
		 StringBuffer sb = new StringBuffer();
		 for(char e:ls.toCharArray())
		 {
			 if((e-'0'>=0 && e-'0'<=9)||(e>96 && e<123))
			 {
				 sb.append(e);
			 }
		 }
//		 System.out.println(sb);
		 String origin = sb.toString(); 
		 // you need to store sb first because whatever operation done to sb, will change sb.
		 String rev =  sb.reverse().toString();
//		 System.out.println(rev);
//		 System.out.println(sb);
		 return origin.equals(rev);
	 }

}
