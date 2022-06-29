/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       
        Node head2 = null;
        Node temp = head;
        Node temp2 = null;
        
        HashMap<Node,Node> map = new HashMap<>();
        
        while(temp != null){
            if(head2==null){
                head2 = new Node(temp.val);
                temp2 = head2;
            }
            else
            {
                temp2.next =  new Node(temp.val);
                temp2 = temp2.next;
            }
            
            map.put(temp , temp2);
            temp = temp.next;
           
        }
        
        temp = head;
        temp2 = head2;
        while(temp!=null){
            Node rand = temp.random;
            if(rand == null)
                temp2.random = null;
            else
                temp2.random = map.get(rand);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}