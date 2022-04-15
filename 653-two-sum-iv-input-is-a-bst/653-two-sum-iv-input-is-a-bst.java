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
    public boolean findTarget(TreeNode root, int k) {
     List<Integer> arr= new ArrayList<>();
        inorder(root,arr);
        int p = 0;
        int q= arr.size()-1;
        int sum = arr.get(p)+arr.get(q);
        while(p<q)
        {
            if(sum>k)
            {
                sum = sum-arr.get(q);
                q = q-1;
                sum = sum+arr.get(q);
            }
            else if(sum<k)
            {
                sum = sum-arr.get(p);
                p = p+1;
                 sum = sum+arr.get(p);
            }
            else if(sum == k)
                return true;
        }
        return false;
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