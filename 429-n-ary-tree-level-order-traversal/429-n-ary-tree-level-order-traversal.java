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
    public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>>ans = new ArrayList<>();
        level(root,ans);
        return ans;
    }
    public void level(Node root,List<List<Integer>> ans)
    {
        if(root==null)
            return ;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0)
        {
            int l= q.size();
            List<Integer> arr = new ArrayList<>();
            while(l>0)
            {
                Node cn= q.poll();
                for(Node i:cn.children)
                {
                    q.add(i);
                }
                arr.add(cn.val);
                l--;
            }
            ans.add(arr);
        }
    }
}