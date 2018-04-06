package lc.q101.SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//22.71%
	public static boolean isSymmetric(TreeNode root) 
	{
		if(root == null)
		{
			return true;
		}
       return isMirror(root.left,root.right);
    }	
	
	public static boolean isMirror(TreeNode p, TreeNode q)
	{
//		if root = [1],then return true
		if(p==null && q==null) return true;
//		if(root = [1,2]) return false
	    if(p==null || q==null) return false;
//	    if(root = [1,2,3] need to compare p.val == q.val)
	    return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
	}
	
//	Short and clean java iterative solution using queue
	public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while(q.size() > 1){
            TreeNode left = q.poll(),
                     right = q.poll();
            if(left== null&& right == null) continue;
            if(left == null ^ right == null) return false;
            if(left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);            
        }
        return true;
    }

}
