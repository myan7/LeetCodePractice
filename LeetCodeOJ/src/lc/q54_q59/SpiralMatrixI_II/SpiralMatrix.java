package lc.q54_q59.SpiralMatrixI_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 54. Spiral Matrix
 * Medium
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

	public static void main(String[] args) 
	{
		int[][] tc1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] tc2 = {};
		int[][] tc14 = {{2,3}};
		int[][] tc20 = {{7},{9},{6}};
//		System.out.println(Integer.toBinaryString(-1));
		int[][] tc21 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(Arrays.asList(spiralOrder(tc20)));
	}

	public static List<Integer> spiralOrder(int[][] matrix) 
	{
		List<Integer> ans = new ArrayList<>();
		if(matrix.length == 0)
			return ans;
		int rowBeg = 0;
		int colBeg = 0;
		int rowEnd = matrix.length-1;
		int colEnd = matrix[0].length-1;
		
		
		while(rowBeg<= rowEnd && colBeg<=colEnd)
		{
			// to the right
				for(int c = colBeg; c<=colEnd;c++)
				{
					ans.add(matrix[rowBeg][c]);
				}
				rowBeg++; // update the visited row
			
			
			// to the bottom
				for(int r = rowBeg; r<=rowEnd; r++)
				{
					ans.add(matrix[r][colEnd]);
				}
				colEnd--;	 // update the last unvisited col
			
			
			// to the left
			if(rowEnd>=rowBeg)
			{
				for(int c = colEnd; c>=colBeg;c--)
				{
					ans.add(matrix[rowEnd][c]);
				}
				rowEnd--; // update the last unvisited row
			}
			
			// to the top
			if(colEnd>=colBeg) 
			{
				for(int r = rowEnd; r>=rowBeg;r--)
				{
					ans.add(matrix[r][colBeg]);
				}
				colBeg++; // update the visited col
			}
			
		}
		return ans;
		
		
    }
	
//	private static List<Integer> helper(int[][] matrix, int r, int c, List<Integer> ans)
//	{
//		while()
//		return ans;
//	}
}
