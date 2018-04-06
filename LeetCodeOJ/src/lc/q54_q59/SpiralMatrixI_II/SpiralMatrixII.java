package lc.q54_q59.SpiralMatrixI_II;
/*
 * 59. Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {

	public static void main(String[] args) 
	{	
		int tc1 = 3 ;
		int[][] ans = generateMatrix(4);
		for(int r = 0; r<ans.length;r++)
		{
			for(int c = 0; c<ans[0].length;c++)
			  System.out.print(ans[r][c]+" ");
			System.out.println();
		}
		

	}
	public static int[][] generateMatrix(int n) 
	{
		int[][] matrix = new int[n][n];
		int rowEnd = n-1, colEnd = n-1;
		int rowBeg = 0, colBeg = 0;
		int value = 1;
		while(rowBeg<=rowEnd && colBeg<=colEnd && value<= n*n)
		{
			//to the right
			for(int c = colBeg; c<=colEnd;c++)
			{
				matrix[rowBeg][c] = value++;
			}
			rowBeg++;
			// to the bottom
			for(int r = rowBeg;r<=rowEnd;r++)
			{
				matrix[r][colEnd] = value++;
			}
			colEnd--;
			//to the left
			if(rowBeg<= rowEnd)
			{
				for(int c = colEnd; c>=colBeg;c--)
				{
					matrix[rowEnd][c] = value++;
				}
				rowEnd--;
			}
			//to the top
			if(colBeg<=colEnd)
			{
				for(int r = rowEnd; r>=rowBeg;r--)
				{
					matrix[r][colBeg] = value++;
				}
				colBeg++;
			}
		}
		return matrix;
	}

}
