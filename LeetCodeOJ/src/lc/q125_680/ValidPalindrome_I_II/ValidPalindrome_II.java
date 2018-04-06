package lc.q125_680.ValidPalindrome_I_II;
/*
 *  680. Valid Palindrome II
 *  Easy
 *  Given a non-empty string s, you may delete at most one character. 
 *  Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

 */
public class ValidPalindrome_II {

	public static void main(String[] args) 
	{
		String tc458 = "lcupuupucul";
		String tc455 = "lucupuupucl";
		String tc457 ="aydmda";
		System.out.println(validPalindrome(tc458));
	}

//	39.97%
    public static boolean validPalindrome(String s) 
    {
        int beg = 0;
        int end = s.length()-1;
        int count = 0;
        while(beg<end)
        {
            if(count>1)
                return false;
            if(s.charAt(beg)==s.charAt(end))
            {
                beg++;
                end--;
            }else
            {
                if(end -beg ==1)
                    return true;
                else if(s.charAt(beg+1)==s.charAt(end) && s.charAt(beg+2) == s.charAt(end-1))
                {
                    beg = beg+1;
                    count++;
                }else if(s.charAt(beg)== s.charAt(end-1)&& s.charAt(beg+1) == s.charAt(end-2))
                {
                    end = end-1;
                    count++;
                }else
                    return false;
            }
        }
        return count<=1;
    }
    
//    75.72%
    public static boolean validPalindrome1(String s)
    {
    	int l = -1, r = s.length();
        while (++l < --r) 
            if (s.charAt(l) != s.charAt(r)) 
            	return isPalindromic1(s, l, r+1) || isPalindromic1(s, l-1, r);
        return true;
    }

    public static boolean isPalindromic1(String s, int l, int r) {
        while (++l < --r) 
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
    
    
//    35.72%
    public boolean validPalindrome2(String s) 
    {
        int l = 0, r = s.length()-1;
        while (l < r)
        {
            if(s.charAt(l)==s.charAt(r))
            {
                l++;
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) 
            	return isPalindromic2(s, l, r-1) || isPalindromic2(s, l+1, r);
        }
           
        return true;
    }

    public boolean isPalindromic2(String s, int l, int r) {
        while (l < r)
        {
            if(s.charAt(l)== s.charAt(r))
            {
                l++;
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) 
                return false;
        }
          
        return true;
    }
}
