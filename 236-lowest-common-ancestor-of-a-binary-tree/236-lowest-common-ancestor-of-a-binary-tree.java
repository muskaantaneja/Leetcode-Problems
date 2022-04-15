/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val==p.val || root.val==q.val)
        {
            return root;
        }
        TreeNode leftans = lowestCommonAncestor( root.left, p,  q);
        TreeNode rightans = lowestCommonAncestor( root.right, p,  q);
        
        if(leftans!=null && rightans!=null)
            return root;
        
        if( rightans!=null)
            return rightans;
        
        if(leftans!=null )
            return leftans;
        
        return null;
        
    }
}