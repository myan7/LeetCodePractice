package lc.q520.DetectCapital;
/*
 * 520. Detect Capital
 * Easy
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


 */
public class DetectCapital {

	public static void main(String[] args) 
	{
		String tc1 = "mL";
		String tc2 = "cVe";
		String tc3 = "oRZ";
	}

	public boolean detectCapitalUse2(String word) 
	{
        boolean isFirst = false;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) 
            {
                if (i == 0) 
                {
                    isFirst = true;
                }
                count++;
                if (count < i + 1) 
                	return false;
            }
        }
        return (isFirst && (count == 1 || count == word.length())) || count == 0 ;
    }
	
	public boolean detectCapitalUse(String word) 
	{
		if(word.charAt(0)-'a'>=0)
		{
			return word.substring(1, word.length()).toLowerCase().equals(word.substring(1, word.length()));
		}
		if(word.charAt(0)-'A'>=0)
		{
			return word.substring(1, word.length()).toLowerCase().equals(word.substring(1, word.length())) ||
					word.substring(1, word.length()).toUpperCase().equals(word.substring(1, word.length()));
		}
		return true;
	}
	
	public static boolean detectCapitalUse1(String word) {

        if(word.length() ==1)
            return true;
        if(word.length()==2)
        {
            if(word.charAt(0)-'a'>=0)
                return word.charAt(1)-'a'>=0;
        }
        for(int i = 1;i<word.length()-1;i++)
        {
           if(word.charAt(0)-'a'>=0)
           {
               if(word.charAt(i)-'a'<0 || word.charAt(word.length()-1)-'a'<0)
                   return false;
           }else
           {
               if('Z'-word.charAt(0)>=0)
               {
                   if((word.charAt(i)-'A'>=26 && word.charAt(i+1)-'A'<26) || (word.charAt(i)-'A'< 26 && word.charAt(i+1)-'A'>=26))
                return false;
               }
           }
                
        }
        return true;
    }

}
