package lc.q112.PathSum;
/*
 * 112. Path Sum  Easy
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 */

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean hasPathSum(TreeNode root, int sum) 
	{

			if(root == null)
			return false;
			
			if(root.left == null && root.right == null && root.val == sum)
	        {
	        		 return true;
	        }
	        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -root.val);
    }
	
	public static boolean hasPathSum1(TreeNode root, int sum) 
	{
			if(root == null) 
				return false;
			if(sum-root.val ==0 && root.left ==null && root.right ==null)
				return true;
			return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
//			the main idea is to subtract the val of a node from sum step by step
//			what is the base case?
//			when the cursor goes to a leaf node, and the sum becomes 0, return true;
//			when the cursor goes to a leaf node, without trigger the true statement in the second if, return false.
			
	}

}
