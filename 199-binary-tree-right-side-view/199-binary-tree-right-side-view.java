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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
       
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0)
        {
            int cs = q.size();
            TreeNode cn = new TreeNode(0);
            while(cs>0){
                cn = q.poll();
               
                if(cn.left!=null)
                    q.add(cn.left);
                if(cn.right!=null)
                    q.add(cn.right);
                cs--;
            }
            list.add(cn.val);
            
        }
        return list;
    }
    
}