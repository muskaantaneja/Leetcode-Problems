/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        
        return maximumdepth(root);
    }
    public int maximumdepth(Node root)
    {
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        int ans = 0;
        while(q.size() > 0){
            
            int cn = q.size();
            
            while(cn > 0){
                
                 Node current = q.poll();
                
                 for(Node temp : current.children ){
                     q.add(temp);
                 }
                
                cn--;
            }
            
            ans++;
        }
        
        return ans;
    }
}