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
class Pair{
    TreeNode parent ;
    int depth ;
    Pair(TreeNode x , int y){
        parent = x;
        depth = y;
    }
    
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null)
            return false;
        
        Pair xinfo = new Pair(null , -1);
        Pair yinfo = new Pair(null , -1);
        return checkCousins(root , null ,  0 ,x , y , xinfo , yinfo);
    }
    
    public boolean checkCousins(TreeNode root , TreeNode parent , int depth ,int x ,                                 int y,Pair xinfo ,Pair yinfo){
        
        if(root == null)
            return false;
        
        if(root.val == x)
        {
            xinfo.parent = parent;
            xinfo.depth = depth;
        }
        if(root.val == y)
        {
            yinfo.parent = parent;
            yinfo.depth = depth;
        }
        if(xinfo.depth!=-1 && yinfo.depth!=-1){
            
            if(xinfo.depth == yinfo.depth && xinfo.parent != yinfo.parent)
                return true;
            else
                return false;
        }
        
        if(checkCousins(root.left , root, depth+1 , x , y , xinfo , yinfo))
            return true;
        
        if(checkCousins(root.right , root, depth+1 , x , y , xinfo , yinfo))
            return true;
        
        return false;
    }
}