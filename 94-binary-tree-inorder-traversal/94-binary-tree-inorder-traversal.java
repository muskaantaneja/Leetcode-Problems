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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(stack.size() > 0){
            TreeNode current = stack.pop();
           // System.out.println(current.val);
            ans.add(current.val);
            if(current.right!=null)
                stack.push(current.right);
            
            current = current.right;
            while(current!=null && current.left!=null)
            {
                stack.push(current.left);
                current = current.left;
            }
        }
        
        return ans;
    }
}