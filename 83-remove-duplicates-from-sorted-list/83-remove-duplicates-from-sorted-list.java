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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if(head == null || head.next == null)
            return head;
        ListNode q = head.next;
        
        while(q!=null){
            
            while(q != null && p.val == q.val){
                q = q.next;
                p.next = null;
                p.next = q;
            }
            
            p = p.next;
            if(q!=null)q = q.next;
        }
        
        return head;
    }
}