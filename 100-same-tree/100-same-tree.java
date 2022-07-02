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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null && q == null)
            return true;
        
        if( p == null || q==null)
            return false;
        
        return issame(p).equals(issame(q));
    }
    public String issame(TreeNode p){
        if(p == null){
            return "-";
        }
        
        return p.val + "-" + issame(p.left) + "-" + issame(p.right);
    }
}