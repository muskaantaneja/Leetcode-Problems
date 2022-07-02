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
    public List<Integer> postorderTraversal(TreeNode root) {
       
        
        List<Integer> ans = new ArrayList<>();
        
        if(root==null)
            return ans;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.add(root);
        
        while(stack.size() > 0){
            
            TreeNode current = stack.pop();
            ans.add(current.val);
            if(current.left!=null)stack.add(current.left);
            if(current.right!=null)stack.add(current.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}