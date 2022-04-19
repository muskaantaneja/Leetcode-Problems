/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}https://assets.leetcode.com/uploads/2020/10/28/recover2.jpg
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
     
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val =temp;
        return;
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        if(prev != null && root.val < prev.val)
        {
            if(first==null)
            {
                first = prev;
                second = root;
            }
            else
                second = root;
        }
        prev = root;
        inorder(root.right);
        return;
    }
}