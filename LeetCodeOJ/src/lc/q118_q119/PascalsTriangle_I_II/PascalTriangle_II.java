package lc.q118_q119.PascalsTriangle_I_II;

import java.util.ArrayList;
import java.util.List;

/*
 * 119. Pascal's Triangle II
 * Easy
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?


 */
public class PascalTriangle_II {

	public static void main(String[] args) {
		getRow1(3);
	}
	
//	87.81%
	public static List<Integer> getRow1(int rowIndex) {
        int[] prev = new int[rowIndex + 1];
        prev[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) 
        {
            int[] curr = new int[rowIndex + 1];
            for (int j = 0; j < i; j++) 
            {
                if (j == 0) {
                    curr[j] = 1;
                } else {
                    curr[j] = prev[j] + prev[j - 1];
                }                
            }
            curr[i] = 1;
            prev = curr;
            
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(prev[i]);
        }
        return list;
    }
	
//	10.58%
	public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0;i<=rowIndex;i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j<i+1;j++)
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }else
                {
                    row.add(ans.get(i-1).get(j-1)+ ans.get(i-1).get(j));
                }
            }
            ans.add(row);
        }
        return ans.get(rowIndex);
    }
}
