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
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode , Integer> memo = new HashMap<>();
        maximumPath(root , memo);
        int maxi = -1000;
        for(TreeNode i : memo.keySet())
        {
            maxi = Math.max(memo.get(i) , maxi);
           // System.out.println(i.val + " " +maxi);
        }
        return maxi;
    }
    public int maximumPath(TreeNode root , HashMap<TreeNode , Integer> memo)
    {
        if(root==null)
            return 0;
        
        
        int val = root.val;
        int left =  maximumPath(root.left , memo);
        int right = maximumPath(root.right, memo);
        
        int ans = val;
        ans += (val + left > val) ? left : 0;
        ans += (val+right > val) ? right: 0;
        memo.put(root, ans);
        return Math.max(val + left , Math.max(val ,val + right));
    }
}