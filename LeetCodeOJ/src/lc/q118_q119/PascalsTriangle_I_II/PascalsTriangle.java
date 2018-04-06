package lc.q118_q119.PascalsTriangle_I_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 118. Pascal's Triangle
 * Easy
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalsTriangle {

	public static void main(String[] args) {

	}
	
	public List<List<Integer>> generate(int numRows) 
	{
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i =0;i<numRows;i++)
        {
        	List<Integer> row = new ArrayList<>();
        	
        	for(int j =0;j<i+1;j++)
        	{
        		if(j==0 || j==i)
        		{
        			row.add(1);
        		}else
        		{
        			row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
        		}
        	}
        	ans.add(row);
        }
        return ans;
    }

}
