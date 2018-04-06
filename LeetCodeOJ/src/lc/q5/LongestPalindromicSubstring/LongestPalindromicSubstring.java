package lc.q5.LongestPalindromicSubstring;
/*
 * 5. Longest Palindromic Substring
 * Medium
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
//		System.out.println(isPalindrome("ababa",0,3));
		String tc1 = "babad";
		String tc2 = "cbbd";
		String tc3 = "aaaa";  // Output: Exception Expected: "aaaa", add && j-i>max 
		String tc4 = "a";  // Output: "" Expected: "a"
		String tc52 = "abb";  // Output: "a" Expected: "bb"
		String tc94 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//TLE after changing traditional isPalindrome to sb.reverse()
		String tc34 = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"; 
		StringBuffer sb = new StringBuffer(tc1.substring(0, tc1.length()));
		System.out.println(sb.reverse().toString());
		System.out.println(tc94);
		System.out.println(sb.toString().equals(sb.reverse().toString()));
		System.out.println(longestPalindrome(tc1));
	}
	
	
//	tc94/94 208ms TLE Time Limit Exceeded 
	public static String longestPalindrome(String s) 
	{
		if(s.length()<2)
			return s;
		int max = 0;
		int beg = 0;
        for(int i =0;i<s.length();i++)
        {
        	for(int j = s.length();j>=i;j--)
        	{
        		if(isPalindrome(s,i,j) && (j-i)>max)
        		{
        			max = Math.max(j-i, max);
        			beg = i;
        		}
        		if(max == s.length())
        			return s;
        	}
        }
        return s.substring(beg, beg+max);
    }
	
	private static boolean isPalindrome(String s,int left, int right)
	{
		while(left<right)
		{
			if(s.charAt(left++)!=s.charAt(--right))
			{
				return false;
			}
		}
			return true;
	}
	
	//even slower
//	public static boolean isPalindrome(String s,int left, int right)
//	{
//		StringBuffer sb = new StringBuffer(s.substring(left, right));
//		return sb.toString().equals(sb.reverse().toString());
//	}
	
	
	public static String longestPalindrome1(String s) 
	{
		String res = "";
	    int currLength = 0;
	    for(int i=0;i<s.length();i++)
	    {
	    	if(isPalindrome(s,i-currLength-1,i))
	    	{
              res = s.substring(i-currLength-1,i+1);
              currLength = currLength+2;
	    	}
	    	else if(isPalindrome(s,i-currLength,i))
	    	{
              res = s.substring(i-currLength,i+1);
              currLength = currLength+1;
	    	}
	    }
	    return res;
	}
  
	public static boolean isPalindrome1(String s, int begin, int end)
	{
		if(begin<0) return false;
		while(begin<end)
		{
			if(s.charAt(begin++)!=s.charAt(end--)) return false;
		}
		return true;
	}
	
	
	
//	83.42%
	private int beg,maxLen;
    public String longestPalindrome2(String s) {
    // see the char on current index as the middle of a panlidrome
        if(s.length()<2)
            return s;
        for(int i = 0 ; i<s.length()-1;i++)
        {
            extendPalindrome2(s,i,i);
            extendPalindrome2(s,i,i+1);
        }
        return s.substring(beg,beg+maxLen);
    }
    private void extendPalindrome2(String s, int start, int end)
    {
        while((start>=0 && end<s.length()) && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }
        if(maxLen<end-start-1)
        {
            beg = start+1;
            maxLen = end-start-1;
        }
    }

}
