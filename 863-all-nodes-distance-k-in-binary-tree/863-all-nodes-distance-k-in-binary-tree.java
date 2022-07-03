/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<TreeNode , TreeNode> parents = new HashMap<>();
        
         findparent(root , parents,null);
        root = findtarget(root ,target);
        nodesDistanceK(root , target , k ,new HashSet<>() , parents ,ans);
        
        return ans;
    }
    
    public TreeNode findtarget(TreeNode root , TreeNode target){
        if(root == null)
            return null;
        
        if(root == target)
            return root;
        
        TreeNode h = null;
        h = findtarget(root.left , target);
        if( h != null)
            return h ;
        return findtarget(root.right , target);
    }
    public void findparent(TreeNode root, HashMap<TreeNode,TreeNode> map,TreeNode                                   parent){
        
        if(root == null)
            return ;
        map.put(root , parent);
        
        findparent(root.left,map,root);
        findparent(root.right,map,root);
        
        return;
    }
    
    public void nodesDistanceK(TreeNode root , TreeNode target , int k , HashSet<TreeNode> visited , 
                              HashMap<TreeNode , TreeNode> parents , List<Integer> ans)
    {
        if(root == null)
            return;
        
        if(visited.contains(root))
            return;
        
        if(k==0)
        {
            ans.add(root.val);
            return;
        }
        
        if(k<0)
            return;
        
        visited.add(root);
        nodesDistanceK( root.right ,target ,k-1,visited ,parents ,ans);
        nodesDistanceK( root.left ,target ,k-1,visited ,parents ,ans);
        nodesDistanceK( parents.get(root) ,target ,k-1,visited ,parents ,ans);
        
        return;
    }
}