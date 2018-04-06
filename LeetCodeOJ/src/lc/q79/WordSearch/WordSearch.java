package lc.q79.WordSearch;
/*
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

public class WordSearch {

	public static void main(String[] args) 
	{
		char[][] tc1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word1 = 	"ABCCED";
		char[][] tc86 = {{'a'}};
		String word86 = "a";
		
		System.out.println(exist(tc1,word1));
	}
	
	public static boolean exist(char[][] board, String word) 
	{
		int row = board.length;
		int col = board[0].length;
		for(int r = 0;r<row;r++)
		{
			for(int c = 0; c<col;c++)
			{
				if(existNext(board,r,c,word,0))
					return true;
			}
		}
		return false;
	}
	
	private static boolean existNext(char[][] board,int r, int c, String word, int idx)
	{
		int row = board.length;
		int col = board[0].length;
		boolean ans = false;
		
			
		char curr = word.charAt(idx);
		if (board[r][c] != word.charAt(idx)) 
			ans= false;
		else
		{
			idx++;
			if(idx == word.length())
			{
				ans = true;
				return ans;
			}
			
			board[r][c] = '*';
			if(r+1<row && curr==word.charAt(idx-1))
          		ans = ans || existNext(board,r+1,c,word,idx);
			if(c+1<col && curr==word.charAt(idx-1))
				ans = ans || existNext(board,r,c+1,word,idx);
			if(r-1>=0 && curr==word.charAt(idx-1))
				ans = ans || existNext(board,r-1,c,word,idx);
			if(c-1>=0 && curr==word.charAt(idx-1))
				ans = ans || existNext(board,r,c-1,word,idx);
			board[r][c]= curr;
		}
			return ans;
		
	}
	
	
	public static boolean exist1(char[][] board, String word)
	{
		char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) 
	    {
	    	for (int x=0; x<board[y].length; x++) 
	    	{
	    		if (exist1(board, y, x, w, 0)) 
	    			return true;
	    	}
	    }
	    return false;
	}

	private static boolean exist1(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) 
			return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length) 
			return false;
		if (board[y][x] != word[i]) 
			return false;
		board[y][x] ^= 256;
		boolean exist = exist1(board, y, x+1, word, i+1)
			|| exist1(board, y, x-1, word, i+1)
			|| exist1(board, y+1, x, word, i+1)
			|| exist1(board, y-1, x, word, i+1);
		board[y][x] ^= 256;
		return exist;
	}

}