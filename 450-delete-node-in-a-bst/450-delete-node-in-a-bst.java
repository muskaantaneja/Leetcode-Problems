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
    public TreeNode deleteNode(TreeNode root, int key) {
       
        if(root == null)
            return root;
        
        if(root.val == key){
            
            if(root.left == null && root.right == null)
                return null;
            
            if(root.right == null)
                return root.left;
            
            if(root.left == null)
                return root.right;
            
            TreeNode q =root;
            q = q.right;
            while(q.left!=null){
                q = q.left;
            }
            
            root.val = q.val;
             root.right = deleteNode(root.right , root.val);
            return root;
        }
        
        if(key > root.val)
            root.right = deleteNode(root.right , key);
        else if(key < root.val)
            root.left = deleteNode(root.left , key);
        
        return root;
    }
    // public TreeNode searchBST(TreeNode root, int val) {
    //     if(root==null)
    //         return null;
    //     if(root.val == val)
    //         return root;
    //     if(val > root.val)
    //         return searchBST(root.right,val);
    //     else
    //         return searchBST(root.left,val);
    // }
}