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
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        leafnodes(root1,r1);
        leafnodes(root2,r2);
        if(r1.equals(r2))
            return true;
        return false;
    }
    public void leafnodes(TreeNode root , ArrayList<Integer> list)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            list.add(root.val);
            return;
        }
        leafnodes(root.left,list);
         leafnodes(root.right,list);
    }
}