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
class Pair {
    int level=-1;
    TreeNode parent= new TreeNode(-1);
    Pair(){}
    Pair(int l,TreeNode p){
        level = l;
        parent = p;
    }
    
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> list=new ArrayList<>();
        Pair pairx= new Pair(),pairy = new Pair();
        cousins(root,x,y,pairx,pairy,0);
        if(pairx.level==pairy.level && pairx.parent!=pairy.parent)
            return true;
        return false;
        
    }
    public void cousins(TreeNode root, int x, int y,Pair pairx,Pair pairy,int level)
    {
        if(root==null)
            return ;
        if(root.right==null && root.left==null)
            return;
        if(root.right != null && root.left==null)
        {
            if(root.right.val==x){
                pairx.level=level+1;
                pairx.parent = root;
            }
            if(root.right.val==y){
                pairy.level=level+1;
                pairy.parent = root;
            }
            if(pairx.level==-1||pairy.level==-1)
            cousins(root.right,x,y,pairx,pairy,level+1);
            return;
        }
        if(root.left != null && root.right==null)
        {
            if(root.left.val==x){
                pairx.level=level+1;
                pairx.parent = root;
            }
            if(root.left.val==y){
                pairy.level=level+1;
                pairy.parent = root;
            }
             if(pairx.level==-1||pairy.level==-1)
            cousins(root.left,x,y,pairx,pairy,level+1);
            return;
        }
        if(root.right.val==x){
                pairx.level=level+1;
                pairx.parent = root;
            }
        if(root.right.val==y){
                pairy.level=level+1;
                pairy.parent = root;
            }
        if(root.left.val==x){
                pairx.level=level+1;
                pairx.parent = root;
            }
        if(root.left.val==y){
                pairy.level=level+1;
                pairy.parent = root;
        }
        if(pairx.level==-1||pairy.level==-1)
        {
            cousins(root.left,x,y,pairx,pairy,level+1);
            cousins(root.right,x,y,pairx,pairy,level+1);
        }
        return;
    }
}