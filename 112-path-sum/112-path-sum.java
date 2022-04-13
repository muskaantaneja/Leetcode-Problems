/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
         if(root==null)
            return false;
        return pathsum(root,target-root.val);
    }
    public boolean pathsum(TreeNode root, int target)
    {
        if(root==null)
            return false;
        if(target==0 && root.right==null && root.left==null)
        {
        // System.out.print("yes");
            return true;
        }
        else if(root.right==null && root.left==null)
            return false;
        if(root.left==null&&root.right!=null)
        {
            return pathsum(root.right, target-root.right.val);
        }
        else if(root.right==null&&root.left!=null)
            return pathsum(root.left, target-root.left.val);
        return pathsum(root.left, target-root.left.val)||pathsum(root.right, target-root.right.val);
    }
}