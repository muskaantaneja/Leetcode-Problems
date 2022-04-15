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
    public TreeNode increasingBST(TreeNode root) {
    List<Integer> arr= new ArrayList<>();
        inorder(root,arr);
        TreeNode dummynode =new TreeNode(-1),newRoot=new TreeNode(-1);
        newRoot=dummynode;
        for(int i:arr)
        {
            dummynode.right=new TreeNode(i);
            dummynode = dummynode.right;
        }
        return newRoot.right;
        
    }
    public void inorder(TreeNode root,List<Integer> arr)
    {
        if(root==null)
            return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return;
    }
}