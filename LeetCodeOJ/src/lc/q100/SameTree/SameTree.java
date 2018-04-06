package lc.q100.SameTree;
/*
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 */
public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) 
	{
//		 for testcase p = [], q = []
		if(p == null && q == null) return true;
//		after take the scenario both are null into consideration, I need to think about what if there is only one null
		if(p == null || q == null) return false;
        if(p.val == q.val)
        {
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else
        	return false;
    }
}


