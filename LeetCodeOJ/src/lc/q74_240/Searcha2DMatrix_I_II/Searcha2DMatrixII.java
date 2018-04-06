package lc.q74_240.Searcha2DMatrix_I_II;
/*
 * 240. Search a 2D Matrix II
 * Medium
 * Category: Array
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class Searcha2DMatrixII {

	public static void main(String[] args) {

	}
	//******************************************************************************
	//I am trying to figure out a binary search method, still need to find out how.
	//******************************************************************************
	public static boolean searchMatrix1(int[][] matrix, int target) 
	{
		boolean result = false;
		if(matrix.length == 0|| matrix[0].length ==0 || matrix == null)
			return result;
		int rowEnd = matrix.length;
		int colEnd = matrix[0].length;
		int rowBeg = 0,colBeg=0;
		while(rowBeg<=rowEnd)
		{
			int rowMid = rowBeg + (rowEnd-rowBeg)/2;
			int colMid = colBeg + (colEnd-colBeg)/2;
			if(target== matrix[rowMid][colMid])
			{
				return true;
			}
			if(target<matrix[rowMid][colMid])
			{
			
			}
		}
		return result;
    }
	
//	46.72%
	public static boolean searchMatrix(int[][] matrix, int target)
	{
		if(matrix.length==0 || matrix ==null)
            return false;
        int r = 0, c= matrix[0].length-1;
        while(r<matrix.length && c>=0)
        {
            if(matrix[r][c] == target)
            {
                return true;
            }else if(target < matrix[r][c])
                c--;
            else 
                r++;
        }
        return false;
	}
}
