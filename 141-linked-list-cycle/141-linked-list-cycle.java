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
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        if(head == null || head.next == null)
            return false;
        ListNode q = head.next.next;
        
        while(q!=null && q.next != null){
            if(p == q)
                return true;
            q = q.next.next;
            p = p.next;
        }
        
        return false;
    }
}