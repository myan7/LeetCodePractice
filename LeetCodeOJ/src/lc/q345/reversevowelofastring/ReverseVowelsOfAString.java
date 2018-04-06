/*
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse 
 * only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 * 
 * */


package lc.q345.reversevowelofastring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s = "hellO";
		String ans = reverseVowels(s);
		System.out.println(ans);
	}
	
//	481 / 481 test cases passed.
//	Status: Accepted
//	Runtime: 14 ms
	public static String reverseVowels(String s) 
	{
		String ans = new String();
		if(s == null) ans =s;  
		StringBuffer sb = new StringBuffer(s);
		StringBuffer vowIns = new StringBuffer();
		char[] sch = s.toCharArray();
		for(char v: sch)
		{
			if(isVowel(v))
			{
				vowIns.append(v);
			}
		}
		char[] vowInsch = vowIns.reverse().toString().toCharArray();
		int start = 0;
		for(int i = 0;i<sch.length;i++)
		{
			if(isVowel(sch[i]))
			{
				sch[i] = vowInsch[start++];
			}
		}
		
		ans = new String(sch);
		return ans;
    }
	public static boolean isVowel(char ch)
	{
		char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
		
		for(char a: vowels)
		{
			if(ch==a)
				return true;
		}
		return false;
	}

	
/*481 / 481 test cases passed.
Status: Accepted
Runtime: 16 ms
 * */	
	public static String reverseVowels2(String s)
	{
		 char[] list=s.toCharArray();
//		Set<Character> set=new HashSet<>();
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//        set.add('A');
//        set.add('E');
//        set.add('I');
//        set.add('O');
//        set.add('U');   this is not a good way to declare a set
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        for(int i=0,j=list.length-1;i<j;){
            if(!set.contains(list[i])){
                i++;
                continue;
            }
            if(!set.contains(list[j])){
                j--;
                continue;
            }
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(list);
	}
}
