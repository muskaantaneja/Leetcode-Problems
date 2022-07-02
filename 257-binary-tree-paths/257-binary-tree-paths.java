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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        paths(root , ans , "");
        
        return ans;
    }
    public void paths(TreeNode root ,List<String> ans , String str ){
        
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            
            str =  str + root.val;
            ans.add(str);
            return;
        }
        
         paths(root.left , ans , str + root.val + "->" );
         paths(root.right , ans ,str + root.val + "->" );
        return;
    }
}