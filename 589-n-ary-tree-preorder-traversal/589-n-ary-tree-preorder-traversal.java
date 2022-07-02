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
    public List<Integer> preorder(Node root) {
    List<Integer> arr=new ArrayList<Integer>();
        preordertraversal(root,arr);
        return arr;
    }
    public void preordertraversal(Node root,List<Integer> arr)
    {
        if(root==null)
            return;
        Stack<Node> s = new Stack<>();
        
        s.push(root);
        while(s.size() != 0){
            Node current = s.pop();
            arr.add(current.val);
            
            for(int i = current.children.size() - 1; i>=0 ; i-- ){
                s.push(current.children.get(i));
            }
        }
        
    }
}