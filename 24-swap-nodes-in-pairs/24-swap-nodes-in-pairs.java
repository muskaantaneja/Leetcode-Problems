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
    public ListNode swapPairs(ListNode head) {
        return swappairs(head);
    }
     public ListNode swappairs(ListNode head)
     {
         if(head==null || head.next==null)
             return head;
         ListNode first=head;
         ListNode second=head.next;
         ListNode temp=swappairs(first.next.next);
         first.next=temp;
         second.next=first;
         return second;
     }
}