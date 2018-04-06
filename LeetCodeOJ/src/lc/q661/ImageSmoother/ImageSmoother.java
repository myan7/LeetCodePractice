package lc.q661.ImageSmoother;
/*
 * 661. Image Smoother
 * Easy
 * Given a 2D integer matrix M representing the gray scale of an image, 
 * you need to design a smoother 
 * to make the gray scale of each cell 
 * becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. 
 * If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 * 
 */
public class ImageSmoother {

	public static void main(String[] args) 
	{
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,0,1,2}};
//		System.out.println("row(shoule be 3) = "+ matrix.length);
//		System.out.println("col(shoule be 4) = "+ matrix[0].length);
		int[][] ans = imageSmoother(matrix);
		for(int[] e: ans)
		{
			for(int f: e)
			{
				System.out.print(f+" ");
			}
			System.out.println();
		}
	}
	
//	69.67%
	public static int[][] imageSmoother(int[][] M) 
	{
		int row = M.length;
        int col = M[0].length;
        
        int[][] ans = new int[row][col];
/*        You only need to take nine positions into consideration
        (r-1,c-1)		(r-1.c)		(r-1,c+1)
        (r,c-1)			(r,c)		(r,c+1)
        (r+1,c-1)		(r+1,c)		(r+1,c+1)
  */      
        for(int r = 0;r<row ;r++)
        {
        	for(int c =0;c<col;c++)
        	{
        		int sum = M[r][c];
                int count = 1; 
                // count is initialized to be one is becoz M[r][c] is itself 
//                and it should be the first to count in the denominator.
        		if(r-1>=0 && c-1>=0)     // put the most specific conditions at first.
        		{
        			sum +=M[r-1][c-1];
        			count++;
        		}if(r-1>=0 && c+1<col)
        		{
        			sum += M[r-1][c+1];
        			count++;
        		}if(r-1>=0)  			// then the more general conditions
        		{
        			sum += M[r-1][c];
        			count++;
        		}
                if(r+1<row && c-1>=0)
        		{
        			sum += M[r+1][c-1];
        			count++;
        		}
                if(c-1>=0)
        		{
        			sum+= M[r][c-1];
        			count++;
        		}if(r+1<row && c+1<col)
        		{
        			sum += M[r+1][c+1];
        			count++;
        		}
                if(c+1<col)
        		{
        			sum+= M[r][c+1];
        			count++;
        		}if(r+1<row)
        		{
        			sum += M[r+1][c];
        			count++;
        		}
        		ans[r][c] = sum/count;
        	}
        }
        return ans;
    }

}
