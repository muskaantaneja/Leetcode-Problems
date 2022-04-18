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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==1)
            return new TreeNode(nums[0]);
        TreeNode root = new TreeNode(0);
        return arraytobst(nums,0,nums.length-1,(0+nums.length-1)/2,root);
          
    }
    private TreeNode arraytobst(int[] nums,int l ,int r,int mid,TreeNode root)
    {
        if(l>r)
            return null;
        
        root = new TreeNode(nums[mid]);
        root.left = arraytobst(nums,l ,mid-1,(l+mid-1)/2,root.left);
        root.right = arraytobst(nums,mid+1 ,r,(r+mid+1)/2,root.right);
        return root;
    }
}