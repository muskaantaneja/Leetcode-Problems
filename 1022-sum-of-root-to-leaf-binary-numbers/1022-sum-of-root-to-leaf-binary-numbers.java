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
    public int sumRootToLeaf(TreeNode root) {
        
        return sumofleaf(root , "");
         
    }
    public int sumofleaf(TreeNode root, String ans){
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
        {
            ans = ans + root.val;
            return Integer.parseInt(ans,2);
        }
        
        return sumofleaf(root.left, ans + root.val) + 
            sumofleaf(root.right, ans + root.val) ;
    }
}