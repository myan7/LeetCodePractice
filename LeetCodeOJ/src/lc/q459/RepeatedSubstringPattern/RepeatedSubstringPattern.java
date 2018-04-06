package lc.q459.RepeatedSubstringPattern;
/*
 * 459. Repeated Substring Pattern
 * Easy
 * Given a non-empty string check if 
 * it can be constructed by taking a substring of it 
 * and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters only
 * and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		String tc1 = "aaa";
		String tc2 = "aba";
		String tc3 = "ababab";
		String tc4 = "ababaababa";
		System.out.println(repeatedSubstringPattern1(tc3));
//		System.out.println(tc3.indexOf('b', 0));
//		System.out.println(tc3.indexOf('a', 1));
//		
	}
	
	
//	97.90%
	public static boolean repeatedSubstringPattern1(String s) {
	       int len = s.length();
	        for( int i = len/2; i >= 1; i-- )
	        {
	            if ( len % i == 0 )
	            {
	                String unit = s.substring(0,i);
	                int j = i;
	                while ( j < len )
	                {
	                    if(! s.substring(j, j+i).equals(unit) )
	                    {
	                        break;
	                    }
	                    else
	                        j += i;
	                }
	                if ( j == len ) return true;
	            }
	        }
	        return false;
	    }
	
//	55ms
	public static boolean repeatedSubstringPattern2(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) 
        {
            if(l%i==0) 
            {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) 
                	return true;
            }
        }
        return false;
    }
    
//	18.63% 122ms
	public static boolean repeatedSubstringPattern(String s) 
	{ // if you can start from s.length()/2, set boundary as i>=1 and decrement i--
//		the speed will fast as twice as right now. 40.14%
		for(int i =1;i<=s.length()/2;i++)
		{
			StringBuffer sb = new StringBuffer();
			if(s.length()%i==0)
			{
				String temp = s.substring(0, i);
				while(sb.length()<s.length())
					sb.append(temp);
				if(sb.toString().equals(s))
					return true;
			}
		}
		return false;
    }
	
//	40.14% 61ms
	 public static boolean repeatedSubstringPattern3(String s) {
	        
	        for(int i =s.length()/2;i>=1;i--)
			{
	            StringBuffer sb = new StringBuffer();
				if(s.length()%i==0)
				{
					String temp = s.substring(0, i);
					while(sb.length()<s.length())
						sb.append(temp);
					if(sb.toString().equals(s))
						return true;
				}
			}
			return false;
	        
	    }
	
	


}
