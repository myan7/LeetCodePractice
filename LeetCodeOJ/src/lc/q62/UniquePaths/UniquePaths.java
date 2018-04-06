package lc.q62.UniquePaths;
/*
 * 62. Unique Paths
 * Medium
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid 
(marked 'Finish' in the diagram below).

How many possible unique paths are there?

start	0	0	0	0	0	0
	0	0	0	0	0	0	0
	0	0	0	0	0	0	finish
Above is a 3 x 7 grid.	How many possible unique paths are there?

Note: m and n will be at most 100.	

sort like q64
M(3,3):
	0	0	0	
	0	0	0
	0	0	0   
	start = M(0,0) in order to go to M(0,1) or M(1,0), there is only one way. 
	so let's assign 1 to these two spots
	0	1	0
	1	0	0
	0	0	0
	from M(0,1) to M(0,2), from M(1,0) to M(2,0),
	there is only one way because only one direction is allowed
	0	1	1
	1	0	0
	1	0	0
	In order to go to M(1,1), there are two spots can lead to it, M(0,1) or M(1,0)
	so assign 2 to M(1,1);
	0	1	1
	1	2	0
	1	0	0
	In order to go to M(1,2) or M(2,1), there are also two ways for each of them.
	to M(1,2), we can start from M(1,1), or from M(0,2)
	to M(2,1), we can start from M(1,1), or from M(2,0)
	assign 3 to both of these spots.
	0	1	1
	1	2	3
	1	3	0
	for M(2,2), there are two ways, from M(1,2) or from M(2,1)
	0	1	1
	1	2	3
	1	3	6
	
 * 
 *   This is a typical DP problem. first, consider it as a 2 by 2 problem.
 *   in order to go to matrix[i][j], 
 *   the robot has 2 options, from matrix[i-1][j]. or from matrix[i][j-1],
 *   so we can conclude the function matrix[i][j] = matrix[i-1][j]+ matrix[i][j-1]
 *   for the first row and column of the matrix, 
 *   there is only one possible way to get to the next spot because the robot is only allowed to 
 *   go right or down at one time. so  matrix[i][0] = 1, matrix[0][j] = 1;
 */
public class UniquePaths {

	public static void main(String[] args) {

		System.out.println(uniquePaths(3,5));
	}

	public static int uniquePaths(int m, int n) 
	{
		int[][] matrix = new int[m][n];
		for(int i = 0;i<m;i++)
		{
			matrix[i][0] = 1;
		}
		for(int j =0;j<n;j++)
		{
			matrix[0][j]=1;
		}
		for(int i = 1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				matrix[i][j]= matrix[i-1][j]+matrix[i][j-1];
			}
		}
		return matrix[m-1][n-1];
    }
	
	
//	need to figure out this one.
	public static int uniquePaths1(int m, int n)
	{
		if(m == 0 || n == 0)
            return 0;
        if(m == 1 || n == 1)
            return 1;
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        for(int i = 1; i <= k; i++){
            res = res * (N - k + i) / i;
        }
        return (int)res;
	}
}
