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
       
        nodesDistanceK( target , k ,new HashSet<>() , parents ,ans);
        
        return ans;
    }
    
    public void findparent(TreeNode root, HashMap<TreeNode,TreeNode> map,TreeNode                                   parent){
        
        if(root == null)
            return ;
        map.put(root , parent);
        
        findparent(root.left,map,root);
        findparent(root.right,map,root);
        
        return;
    }
    
    public void nodesDistanceK(TreeNode root , int k , HashSet<TreeNode> visited , 
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
        nodesDistanceK( root.right ,k-1,visited ,parents ,ans);
        nodesDistanceK( root.left ,k-1,visited ,parents ,ans);
        nodesDistanceK( parents.get(root) ,k-1,visited ,parents ,ans);
        
        return;
    }
}