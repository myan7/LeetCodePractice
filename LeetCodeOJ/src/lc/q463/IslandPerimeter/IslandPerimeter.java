package lc.q463.IslandPerimeter;
/*
 * 463. Island Perimeter
 * Easy
 * You are given a map in form of a two-dimensional integer grid 
 * where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, 
 * and there is exactly one island (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" 
 * (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. 
 * The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] tc1 = {{0,1,0,0},
		               {1,1,1,0},
		               {0,1,0,0},
		               {1,1,0,0}};
		System.out.println(islandPerimeter(tc1));
	}
	
//	77.61%
	public static int islandPerimeter(int[][] grid) 
	{
		int row = grid.length;
		int col = grid[0].length;
		int perimeter = 0;
		for(int r = 0;r<row;r++)
		{
			for(int c = 0;c<col;c++)
			{
				if(grid[r][c]==1)
				{
					if(r-1<0 || grid[r-1][c] ==0)
						perimeter++;
					if(c-1<0 || grid[r][c-1] == 0)
						perimeter ++;
					if(r+1==row ||grid[r+1][c] == 0)
						perimeter++;
					if(c+1 == col || grid[r][c+1] == 0)
						perimeter++;
				}
				
//				if(count ==4)
//					perimeter +=4;
//				if(count == 3)
//					perimeter +=3;
//				if(count ==2 )
//					perimeter+=2;
//				if(count ==1 )
//					perimeter +=1;  you don't need a count to count the number of zero's around 1
			}
		}
		return perimeter;
    }
	
	public static int islandPerimeter1(int[][] grid) {
        int perimeter = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != 0) perimeter += getPerimeter(grid, r, c);
            }
        }
        
        return perimeter;
    }
    
    public static int getPerimeter(int[][] grid, int r, int c) {
        int p = 0;
        if (r == 0 || grid[r - 1][c] == 0) p++;
        if (r == grid.length - 1 || grid[r + 1][c] == 0) p++;
        if (c == 0 || grid[r][c - 1] == 0) p++;
        if (c == grid[0].length - 1 || grid[r][c + 1] == 0) p++;
        return p;
    }

}
