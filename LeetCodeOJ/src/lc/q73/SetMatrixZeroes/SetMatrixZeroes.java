package lc.q73.SetMatrixZeroes;

import java.util.ArrayList;
import java.util.List;

/*
 * 73. Set Matrix Zeroes
 * Medium
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * 
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] tc1 = {{0}};
		int[][] tc2 = {{1},{0}};
		int[][] tc3 = {{1,2,3,4,5,6,7,8,9},{2,3,4,5,6,7,8,0,9},{3,0,2,4,5,6,7,8,9},{9,2,3,4,5,6,7,0,8}};
		setZeroes1(tc3);
		for(int[] a: tc3)
		{
			for(int e: a)
			{
				System.out.print(e+" ");
			}
			System.out.println();
		}
		
	}
	
//	20.41%
	public static void setZeroes1(int[][] matrix)
	{
/*
 * The idea is in the first for loop, 
 * find 0 element and mark the element on first row and the first column as 0
 * to keep a record, which row and column should be 0 according to the first row and column status;
 * 
 * then in the second loop, find which one row and column should be all 0 and mark them.
 * why j starts from 1?
 * {{1,1,1},{0,1,2}} should be {{0,1,1},{0,0,0}}
 * if j starts from 0, the result will be all 0.
 * 
 * Also notice that the first loop starts from top left, and the second loop starts from bottom right.
 * 
 * at last, change the first column to be all 0 if matrix[0][0] == 0 (already marked by col0=0)
 */
		int row = matrix.length,col = matrix[0].length;
		int col0 = 1;
		for(int i =0;i<row;i++)
		{
			if(matrix[i][0]==0)
				col0=0; // as long as one element on column 0 is 0, mark col0 =0.
			for(int j =1;j<col;j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i = row-1;i>=0;i--)
		{
			for(int j = col-1;j>=1;j--)
			{
				if(matrix[i][0] == 0 || matrix[0][j]==0)
					matrix[i][j]=0;
			}
			if(col0==0) matrix[i][0]=0;
		}
	}
	
	public static void setZeroes(int[][] matrix) {
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        
        List<ArrayList<Integer>> corrdinates = new ArrayList<ArrayList<Integer>>();
        while(r<row)
        {
        	c=0;
        	while(c<col)
        	{
        		ArrayList<Integer> cor = new ArrayList<>();
        		if(matrix[r][c] == 0)
            	{
        			cor.add(r);
        			cor.add(c);
        			corrdinates.add(cor);
        			c++;
            	}else
            		c++;
        	}
        	r++;
        }
        
        for(ArrayList<Integer> al: corrdinates)
        {
        	int rr = (int) al.get(0);
        	int cc = (int) al.get(1);
        	        	
        	for(int i = 0; i<col;i++)
        	{
        		matrix[rr][i]=0;
        	}
        	for(int i = 0;i<row;i++)
        	{
        		matrix[i][cc]=0;
        	}
        }  
    }
}
