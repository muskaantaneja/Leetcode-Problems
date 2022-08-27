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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        
        
        if(root == null)
            return false;
        
        if(root.val == subroot.val){
            if(issame(root,subroot) == true)
                return true;
        }
        
        return isSubtree(root.left , subroot) || isSubtree(root.right , subroot) ;
    }
    public boolean issame(TreeNode root1 , TreeNode root2)
    {
        
        if(root1==null && root2==null)
            return true;
        
        if(root1 == null || root2 == null)
            return false;
        
        if(root1.val != root2.val)
            return false;
        
        return issame(root1.left , root2.left) && issame(root1.right , root2.right);
    }
}