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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
      int carry = 0;
        ListNode l1 = reverseList(list1);
        ListNode l2 = reverseList(list2);
        
        ListNode list = null;
        ListNode head = null;
        
        while(l1!=null || l2!=null){
            
            int sum = carry;
            sum += (l1==null) ? 0 : l1.val;
            sum += (l2 == null) ? 0 : l2.val;
            
            if(list == null){
                list = new ListNode(sum % 10);
                head = list;
            }
            else
                list.next = new ListNode(sum % 10);
            
            if(list!= null && list.next != null)
               list = list.next; 
            carry =  sum/10;
            if(l1 != null)
            l1 = l1.next;
            if(l2!=null)
            l2 = l2.next;
        }
    
    
    if(carry != 0){
        if(list == null){
                list = new ListNode(carry);
            head = list;
            }
            else
                list.next = new ListNode(carry);
    }
    
    return reverseList(head);
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