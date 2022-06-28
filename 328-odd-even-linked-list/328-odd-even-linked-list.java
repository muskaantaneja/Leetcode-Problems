/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next== null || head.next.next == null)
            return head;
        
        ListNode p= head;
        ListNode q = head.next;
        
        while(q.next!=null){
            q = q.next;
        }
        
        ListNode r = q;
        ListNode d = r;
        q = p.next;
        
        while(p!=r && q!=r){
            p.next = p.next.next;
            q.next = null;
            d.next = q;
            p = p.next;
            if(p!=null)
            {
                q = p.next;
            }
            d = d.next;
        }
        
        if(q == r){
            p.next = p.next.next;
            q.next = null;
            d.next = q;
            
        }
        
        return head;
    }
}