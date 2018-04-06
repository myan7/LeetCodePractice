package lc.q20.validparentheses;

import java.util.Stack;

/*
 * 20. Valid Parentheses
 * Given a string containing 
 * just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

The brackets must close in the correct order, 
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * */

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	My thought was to transfer the characters into ints,
//	for example: '('=1, ')'=-1; '['=2, ']'=-2; '{'=3, '}'=-3;
//	([)] is not valid, so the thought is not enough correct. 
	
//	73 / 73 test cases passed.
//	Status: Accepted
//	Runtime: 10 ms
	 public static boolean isValid(String s) 
	 {
		 Stack<Character> st = new Stack<Character>();
		 for(char e: s.toCharArray())
		 {
			 if(e=='(')
				 st.push(')');
			 else if(e =='[')
				 st.push(']');
			 else if(e == '{')
				 st.push('}');
			 else if(st.isEmpty() || st.pop()!=e)
				 return false;
		 }
		 return st.isEmpty();  
	 }

}
