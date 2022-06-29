/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null|| head.next == null)
            return null;
        
        ListNode p = head;
        ListNode q = head;
        if(p.next==null || q.next.next == null)
        {
            return null;
        }
        
        p = p.next;
        q = q.next.next;
        while(p!=q){
            if( p == null || q==null)
                return null;
            p=p.next;
            if(q.next == null)
                return null;
            q = q.next.next;
        }
        
        ListNode empty = head;
        while(empty != p){
            empty = empty.next;
            p = p.next;
        }
        
        return p;
    }
}