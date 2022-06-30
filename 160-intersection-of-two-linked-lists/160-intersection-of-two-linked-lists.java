/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode head1 = headA , head2 = headB;
        int count1 = 0 , count2 = 0;
        while( head1 != null){
            head1 = head1.next;
            count1++;
        }
        while( head2 != null){
            head2 = head2.next;
            count2++;
        }
        
        if(count1 <= count2){
            head1 = headA;
            head2 = headB;
        }
        else{
            head1 = headB;
            head2 = headA;
        }
        
        int count = Math.abs(count1 - count2);
        
       
        
       // System.out.println(count);
        while(head2 != null && count > 0){
            head2 = head2.next;
            count--;
        }
       // if(head2!=null)System.out.println(head2.val);
        while(head2!=null && head1!=null && head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return head1;
    }
}