package lc.q104.MaximumDepthofBinaryTree;
/*
 * 104. Maximum Depth of Binary Tree  Easy
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 */

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	90.46%
	public static int maxDepth(TreeNode root) 
    {
		if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
	}
	
//	
	public static int maxDepth1(TreeNode root) 
    {   
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root,1,res);
        return res[0];
    }
	
	
//     DFS
    private static void helper(TreeNode root,int depth,int[] res) 
    {
        if (root.left == null && root.right == null) {
            res[0] = Math.max(res[0],depth);
        }
        if (root.left != null) {	
            helper(root.left,depth + 1,res);
        }
        if (root.right != null) {
            helper(root.right,depth + 1,res);
        }
    }

    
}
