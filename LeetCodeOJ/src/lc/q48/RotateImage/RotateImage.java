package lc.q48.RotateImage;
/*
 * 48. Rotate Image
 * Medium
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class RotateImage {

	public static void main(String[] args) 
	{
		int[][] tc1 = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(tc1);

	}
/*
* The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
1  2  3             
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])
1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
7  4  1
8  5  2
9  6  3
	 */
	
//	52.84%
	public static void rotate1(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;    // no need to instantiate two variables row and col. n*n matrix.
//        first flip
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
//        then transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
	}
//	10.51%
	public static void rotate(int[][] matrix) 
	{
//		first transpose the matrix
		int row = matrix.length-1;
		int col = matrix[0].length-1;
		for(int r = 0; r<=row;r++)
		{
			for(int c = r;c<=col;c++)  // ***** if c starts from r+1 instead of r, 10.51% --> 52.84%
			{
				int tmp = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r] = tmp;
			}
		}
		for(int r = 0;r<=row;r++)
		{
			for(int c = 0; c<=col;c++)
			{
				System.out.print(matrix[r][c]+"\t");
			}
			System.out.println();
		}
//		then flip horizontally
		for(int r = 0;r<=row;r++)
		{
			for(int c = 0;c<=col/2;c++)
			{
				int tmp = matrix[r][c];
				matrix[r][c] =matrix[r][col-c];
				matrix[r][col-c] = tmp;
			}
		}
		for(int r = 0;r<=row;r++)
		{
			for(int c = 0; c<=col;c++)
			{
				System.out.print(matrix[r][c]+"\t");
			}
			System.out.println();
		}
    }
}
