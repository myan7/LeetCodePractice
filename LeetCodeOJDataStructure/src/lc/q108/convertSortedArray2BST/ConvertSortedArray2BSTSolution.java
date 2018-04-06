package lc.q108.convertSortedArray2BST;
/*
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedArray2BSTSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode sortedArrayToBST(int[] nums) 
	{
			return getTN(nums,0,nums.length-1);
    }
	
	public static TreeNode getTN(int[] nums,int start, int end)
	{
		if (start > end){
            return null;
        }
        int middle = start + (end-start)/2; 
//        avoid integer overflow. try not to use(start+end)/2 
//        because the sum of start and end will be beyond the limitation of an integer.
        TreeNode root = new TreeNode(nums[middle]);
        root.left = getTN(nums, start, middle-1);
        root.right = getTN(nums, middle+1, end);
        return root;
	}
	
//	the same idea as above.
	public static TreeNode sortedArrayToBST1(int[] nums) {
	    return sortedArrayToBST1(nums, 0, nums.length-1);
	}
	public static TreeNode sortedArrayToBST1(int[] nums, int lo, int hi){
	    if(lo > hi)
	        return null;
	    int mid = (hi-lo)/2+lo; // avoid integer overflow.
	    TreeNode root = new TreeNode(nums[mid]);
	    root.left =  sortedArrayToBST1(nums, lo, mid-1);
	    root.right =  sortedArrayToBST1(nums, mid+1, hi);
	    return root;
	}
	    
	
	    
	    
	    
	/*
	 * 
	 * public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
		{
			return null;
		}
		else if(nums.length ==1)
		{
		    return new TreeNode(nums[0]);
		}
		else
		{
			return getTN(nums,0,nums.length-1);
		}
    }
	
	public static TreeNode getTN(int[] nums,int start, int end)
	{
		int middle = (start+end)/2;
		TreeNode root = new TreeNode(nums[middle]);
		if(start == middle)
		{
			root.left = null;
			root.right = new TreeNode(nums[end]);
		}else
		{
			root.left = getTN(nums,0,middle-1);
			root.right = getTN(nums,middle+1,end);
		}
		return root;
    }
	 * 
	 * 
	 */
}

