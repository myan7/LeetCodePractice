package lc.q383.ransomNote;

import java.util.Arrays;

public class RansomNote {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ransomNote = "a";
		String magazine =	"b";
		System.out.println(canConstruct(ransomNote, magazine));
	}

	public static boolean canConstruct(String ransomNote, String magazine) 
	{
       char[] chR = ransomNote.toCharArray();
       char[] chM = magazine.toCharArray();
       
//       Arrays.sort(chR);
//       Arrays.sort(chM);
//		No need to sort it will cost more time than you think.
//      using sort, the time is 113ms (for 126 test cases)
//      without sort, the time is 46ms (for 126 test cases)
       for(int i=0;i<chR.length;i++)
       {
    	   for(int j = 0; j<chM.length;j++)
    	   {
    		   if(chR[i]==chM[j])
    		   {
    			   chR[i]='5';
    			   chM[j]='5';
    			   break;
    		   }
    	   }
       }
       boolean value = true;
       for(char e:chR)
       {
    	   if(e!='5')
    		   value = false;
       }    
		return value;
    }
	
	public static boolean canConstruct2(String ransomNote, String magazine) 
	{
		int[] alpha = new int[26];
		boolean value = true;
		for(int i =0;i<26;i++)
		{
			alpha[i]=0;
		}
		// initiate an array with 26 elements in it representing the alphabet.
		
		for(int i =0;i<magazine.length();i++)
		{
			alpha[magazine.charAt(i)-97]++;
		}
		// if the letter appears in magazine, 
		// value of the corresponding position in the alphabet array +1
		// alpha[0] represents 'a', alpha[1] represents 'b'...
		// alpha[char-'a'] is the corresponding position.
		
		for(int i =0; i<ransomNote.length();i++)
		{
			alpha[ransomNote.charAt(i)-97]--;
		}
		// if the letter appears in ransom note
		// value of its corresponding position -1 
		
		
		for(int e: alpha)
		{
			if(e<0)
				value = false;
		}
		// if any value in the alphabet is less than zero, that means
		// the letter in that position appears more times in ransom than 
		// that in the magazine.
		
		return value;
	}
//	the more concise version of method2
	public static boolean canConstruct3(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

