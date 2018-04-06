package lc.q32.longestvalidparentheses;

import java.util.Stack;

/*
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 */
public class LongestValidParentheses {

	public static void main(String[] args) 
	{
		String testcase1 = ")";
		String tc2 = ")((()()()()()))))(((())()()))((())()())))))(((()()()()()()())))()())()()()()())()";
		System.out.println(longestValidParentheses1(tc2));
	}

	public static int longestValidParentheses1(String s)
	{
		 Stack<Integer> stack = new Stack<Integer>();
	        int max=0;
	        int left = -1;//instead putting '(' into the stack,
//	        the solution posted on the discussion board is to put the index of that specific character into the stack.
//	        Traverse the string from the very beginning to the end.
//	        if:	 	the character is the left parenthesis, then push its index into the stack.
//	        else: 	the character is the right parenthesis, 
//	        			if: stack is empty, left = j, mark the starting point of the consecutive parentheses
//	        			else: pop the index from the stack, make them a pair
//	        					if: no element in the stack, it means the left and right parenthesis are paired
//	        						max is the distance from this position to the starting position.
//	        					else: if the stack is not empty, max still need updating.
	        for(int j=0;j<s.length();j++){
	            if(s.charAt(j)=='(') 
	            	stack.push(j);            
	            else {
	                if (stack.isEmpty()) left=j;
	                else{
	                    stack.pop();
	                    if(stack.isEmpty()) 
	                    	max=Math.max(max,j-left); // left is the starting point, j is current index
	                    else 
	                    	max=Math.max(max,j-stack.peek()); 
	                    	// update the max every time when consecutive pair is found
	                }
	            }
	        }
	        return max;
	}
	
	
//	this method is meant to be upgraded version of the longestValidParentheses1, but LTE error
	public static int longestValidParentheses(String s) 
	{
        Stack<Integer> st = new Stack<Integer>();
        int max = 0;
        st.push(-1);
        for(int i = 0; i<s.length();i++)
        {
        	if(s.charAt(i)==')'&& st.size()>1 && s.charAt(st.peek())=='(' )
        	{
        		st.pop();
        		max = Math.max(max, i-st.peek());
        	}
        	else
        	{
        		st.push(i);
        	}
        }
        return max;
     }
}
