package lc.q648.ReplaceWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *  648. Replace Words
 * In English, we have a concept called root, 
 * which can be followed by some other words to form another longer word 
 * - let's call this word successor. 
 * For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. 
You need to replace all the successor in the sentence with the root forming it. 
If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 */
public class ReplaceWords {

	public static void main(String[] args) {
		String tc1 = "the cattle was rattled by the battery";
		String[] roots = {"cat", "bat", "rat"};
		List<String> dict = new ArrayList<String>();
		for(int i =0;i<roots.length;i++)
		{
			dict.add(roots[i]);
		}
		
	}
	
	public static String replaceWords(List<String> dict, String sentence) {
        String ans = "";
        String[] senStr = sentence.split(" ");
        for(int i=0;i<dict.size();i++)
        {
        	int idx = 0;
        	
        }
        return ans;
    }
	private static boolean isRoot(String s1, String s2)
	{
		Boolean res = false;
		if(s2.contains(s1))
			res = true;
		return res;
	}
	
	
	
//	85.75%
	public static String replaceWords1(List<String> dict, String sentence) 
	{
	 String[] tokens = sentence.split(" ");
     TrieNode trie = buildTrie(dict);
     return replaceWords(tokens, trie);
	}

	private static String replaceWords(String[] tokens, TrieNode root) 
	{
	     StringBuilder stringBuilder = new StringBuilder();
	     for (String token : tokens) 
	     {
	         stringBuilder.append(getShortestReplacement(token, root));
	         stringBuilder.append(" ");
	     }
	     return stringBuilder.substring(0, stringBuilder.length()-1);
	}

	 private static String getShortestReplacement(String token, final TrieNode root) 
	 {
	     TrieNode temp = root;
	     StringBuilder stringBuilder = new StringBuilder();
	     for (char c : token.toCharArray()) 
	     {
	         stringBuilder.append(c);
	         if (temp.children[c - 'a'] != null) 
	         {
	             if (temp.children[c - 'a'].isWord) 
	             {
	                 return stringBuilder.toString();
	             }
	             temp = temp.children[c - 'a'];
	         } 
	         else 
	         {
	             return token;
	         }
	     }
	     return token;
	 }

	 private static TrieNode buildTrie(List<String> dict) 
	 {
	     TrieNode root = new TrieNode(' ');
	     for (String word : dict) 
	     {
	         TrieNode temp = root;
	         for (char c : word.toCharArray()) 
	         {
	             if (temp.children[c - 'a'] == null) 
	             {
	                 temp.children[c - 'a'] = new TrieNode(c);
	             }
	             temp = temp.children[c - 'a'];
	         }
	         temp.isWord = true;
	     }
	     return root;
	 }

// 	public class TrieNode {
//     char val;
//     TrieNode[] children;
//     boolean isWord;
//
//     public TrieNode(char val) {
//         this.val = val;
//         this.children = new TrieNode[26];
//         this.isWord = false;
//     }
// 	}
 
	 
//6.31% 
	 public String replaceWords2(List<String> dict, String sentence) 
	 {
	 if (dict == null || dict.size() == 0) return sentence;
     
     Set<String> set = new HashSet<>();
     for (String s : dict) set.add(s);
     
     StringBuilder sb = new StringBuilder();
     String[] words = sentence.split("\\s+");
     
     for (String word : words) {
         String prefix = "";
         for (int i = 1; i <= word.length(); i++) {
             prefix = word.substring(0, i);
             if (set.contains(prefix)) break;
         }
         sb.append(" " + prefix);
     }
     
     return sb.deleteCharAt(0).toString();
	 }
}
