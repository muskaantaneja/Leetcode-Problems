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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null )
            return list2;
        if(list2 == null )
            return list1;
        ListNode p = list1.val<=list2.val ? list1 : list2;
        ListNode q = (list1.val == p.val) ? list2 : list1;
        ListNode head = p;
        while(p!=null && q!=null){
            
            while(p.next != null && p.next.val < q.val){
                p=p.next;
            }
            
            if(p.next == null){
                p.next =q;
                return head;
            }
            else
            {
                ListNode temp = q;
                q = q.next;
                temp.next = p.next;
                p.next = temp;
                p = p.next;
            }
        }
        return head;
    }
}