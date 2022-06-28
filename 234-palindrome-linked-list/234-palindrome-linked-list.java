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
    public boolean isPalindrome(ListNode head) {
        ListNode head1 = null;
        ListNode p = head;
        ListNode q = null;
        while(p!=null){
            if(q == null){
                q = new ListNode(p.val);
                head1 = q;
            }
            else
            {
                q.next = new ListNode(p.val);
                q = q.next;
            }
            p = p.next;
        }
        ListNode head2 = reverseList(head1);
        
        while(head != null && head2!=null)
        {
            System.out.println(head.val + " _ "+head2.val);
            if(head.val != head2.val)
                return false;
            
            head = head.next;
            head2 = head2.next;
        }
        
        if(head == null && head2 == null)
            return true;
        return false;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode p=null;
        ListNode q=null;
        while(head.next!=null)
        {
            q=head.next;
            head.next=p;
            p=head;
            head=q;
        }
        head.next=p;
        return head;
    }
}