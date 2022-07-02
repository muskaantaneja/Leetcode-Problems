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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        String s1 = leafnodes(root1);
        String s2 = leafnodes(root2);
        
        if(s1.equals(s2))
            return true;
        return false;
        
    }
    public String leafnodes(TreeNode root){
        
        if(root == null)
            return "";
        
        if(root.left == null && root.right == null){
            return "_" + root.val;
        }
        
        return "" + leafnodes(root.left) + leafnodes(root.right);
    }
}