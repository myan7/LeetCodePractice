package lc.q566.reshapethematrix;

public class ReshapetheMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	56 / 56 test cases passed.
//	Status: Accepted
//	Runtime: 8 ms   65.45%
	public static int[][] matrixReshape(int[][] nums, int r, int c) 
	{
        int row = nums.length;
        int col = nums[0].length;
        int num = row*col;
        int[] numsArr = new int[num];
        int pos = 0;
//      transfer the matrix to an array.
        for(int i = 0; i<row; i++)
        {
        	for(int j = 0;j<col;j++ )
        	{
        		numsArr[pos++] = nums[i][j];
        	}
        }
//      if the number of elements are the same, then put in those numbers.
        if( num == r*c)
        {
        	int e = 0;
        	int[][] ans = new int[r][c];
        	for(int i =0; i<r;i++)
        	{
        		for(int j =0;j<c;j++)
        		{
        			ans[i][j] = numsArr[e++]; 
        		}
        	}
        	return ans;
        }else
        	return nums;
    }
	
//	 still O(n^2) because i<r*c 
//	56 / 56 test cases passed.
//	Status: Accepted
//	Runtime: 9 ms  38.01%
	public static int[][] matrixReshape1(int[][] nums, int r, int c)
	{
		int m = nums.length, n = nums[0].length;
	    if (r * c != m * n)
	        return nums;
	    int[][] reshaped = new int[r][c];
	    for (int i = 0; i < r * c; i++)
	        reshaped[i/c][i%c] = nums[i/n][i%n];
	    return reshaped;
	}
}
