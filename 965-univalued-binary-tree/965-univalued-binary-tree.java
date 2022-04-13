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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        int val = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0)
        {
            int currentsize =q.size(); 
            while(currentsize>0)
            {
                TreeNode cn = q.poll();
                if(cn.val!=val)
                    return false;
                if(cn.left!=null)
                    q.add(cn.left);
                if(cn.right!=null)
                    q.add(cn.right);
                currentsize--;
            }
        }
        return true;
    }
}