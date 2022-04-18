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
        List<Integer> ans = new ArrayList<>();
      //  HashSet<Integer> visited = new HashSet<>();
        if(root==null)
            return ans;
        int count =1;
        while(count==1)
        {
            while(root!=null )
            {
                stack.push(root);
               // visited.add(root.val);
                root = root.left;
            }
            if(stack.size()==0)
                break;
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}