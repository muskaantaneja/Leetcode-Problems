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
    public boolean isUnivalTree(TreeNode root) {
        
        if(root == null)
            return true;
        return univaluedtree(root , root.val);
    }
    public boolean univaluedtree(TreeNode root , int val){
        
        if(root == null)
            return true;
        
        if(root.val != val)
            return false;
        
        if(!univaluedtree(root.left , val))
            return false;
        
        if(!univaluedtree(root.right , val))
            return false;
        
        return true;
    }
}