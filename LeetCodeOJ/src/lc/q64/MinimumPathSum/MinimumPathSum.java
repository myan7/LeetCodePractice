package lc.q64.MinimumPathSum;
/*
 * 64. Minimum Path Sum
 * Medium
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 * Sort like q62.
 */


public class MinimumPathSum {

	public static void main(String[] args) {

	}

//	99.41%
	public int minPathSum1(int[][] grid)
	{
		  if(grid.length == 1 & grid[0].length == 1) 
		  {
	            return grid[0][0];
	      }
		  for (int i = 1; i < grid.length; i++) 
		  {
	            grid[i][0] += grid[i - 1][0]; 
	      }
	        
	      for (int j = 1; j < grid[0].length; j++) 
	      {
	            grid[0][j] += grid[0][j - 1];
	      }
	        
	      findPath(grid, 1);
	        int res = grid[grid.length - 1][grid[0].length - 1];
	        return res;
	    }
	    
	    public void findPath(int[][] grid, int i) {
	        if(i == grid.length) {
	            return;
	        }
	        
	        for (int j = 1; j < grid[i].length; j++) {
	            grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
	        }
	        
	        findPath(grid, i + 1);
	}
	
//	32.36%
	public int minPathSum(int[][] grid) 
	{
        //the whole idea is to divide the problem into subproblem
		//you can see each small faction as a small matrix
		// find the minimum path for each small matrix 
//		and then accumulate the results to the last small matrix.
		int col = grid[0].length;
		int row = grid.length;
		for(int r =0;r<row;r++)
		{
			for(int c =0; c<col;c++)
			{
				if(r==0 && c==0)
				{
					grid[r][c] = grid[r][c];
				}else if(r == 0 && c!=0)
				{
					grid[r][c] = grid[r][c]+grid[r][c-1];
				}else if(r!=0 && c ==0)
				{
					grid[r][c] = grid[r][c]+grid[r-1][c];
				}else
				{
					grid[r][c] = grid[r][c]+Math.min(grid[r-1][c],grid[r][c-1]);
				}
			}
		}
		return grid[row-1][col-1];
    }

}
