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
        
        List<Integer> ans = new ArrayList<>();
        
        if(root==null)
            return ans;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.add(root);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(root);
        while(stack.size() > 0){

            TreeNode current = stack.peek();
            if(current.right!=null && !visited.contains(current.right)){
                stack.add(current.right);
                visited.add(stack.peek());
            }
            else
            {
                ans.add(current.val);
                current = stack.pop();
                if(current.left!=null && !visited.contains(current.left))
                {
                    stack.add(current.left);
                    visited.add(stack.peek());
                }
            }
            
        }
        Collections.reverse(ans);
        return ans;
    }
}