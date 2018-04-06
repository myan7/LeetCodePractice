package lc.q74_240.Searcha2DMatrix_I_II;
/*
 * 74. Search a 2D Matrix
 * Meidium
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class Searcha2DMatrix {

	public static void main(String[] args) {
		int[][] tc1 = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target1 = 3;
		int[][] tc2 = {{1},{3},{5}};
		int target2 = 3;
		System.out.println(searchMatrix(tc2,target2));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) 
	{
		 boolean result = false;
	        if(matrix.length == 0 || matrix[0].length==0 ||matrix== null)
	            return result;
	        int row = matrix.length-1;
	        int col = matrix[0].length-1;
	        int begRow = 0,begCol = 0;
	       
	        
	        while(begRow<=row)
	        {
	        	int midRow = begRow+(row-begRow)/2;
	        	if(target >= matrix[midRow][begCol] && target <=matrix[midRow][col])
	        	{
	        		while(begCol<=col)
	        		{
	                    int midCol = begCol+(col-begCol)/2;
	        		    if(target == matrix[midRow][midCol])
	        			    return true;   
	        		    if(matrix[midRow][midCol]<target)
	        				begCol = midCol+1;
	        			else
	        				col = midCol-1;
	        		}
	        	} 
	        	if(matrix[midRow][0]<target)
	        	{
	        		begRow = midRow+1;
	        	}else
	        		row = midRow-1;
	        }
	        return result;
    }

	public static boolean searchMatrix1(int[][] matrix,int target)
	{
		if (matrix.length==0||matrix[0].length==0) 
			return false;
        int m = matrix.length, n = matrix[0].length;
		int lo = 0; int hi = m*n-1;
		while(lo < hi){
			int mid = (lo+hi)/2;
			int val = matrix[mid/n][mid%n];
			if(target == val) 
				return true;
			if(target > val)
				lo = mid+1;
			else 
				hi = mid-1;
		}
		return target == matrix[lo/n][lo%n];
	}
}
