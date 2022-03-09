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
        if(head==null)
            return head;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        ListNode p = head;
        while(p!=null)
        {
            if(map.containsKey(p.val))
            {
                int h = map.get(p.val)+1;
                map.put(p.val,h);
            }
            else
                map.put(p.val,1);
            p=p.next;
        }
        
        p=null;
        ListNode q =null;
        while(head!=null && map.get(head.val)>1)
        {
            ListNode temp=head;
            head=head.next;
            temp.next=null;
        }
        
        q = head;
        if(head!=null && head.next!=null)p = head.next;
        
         while(p!=null)
        {
             
           if(map.get(p.val)>1)
           {
               q.next=p.next;
               p.next=null;
               p = q.next;
           }
            else
            {
                q=q.next;
                p=q.next;
            }
             
        }
        
        
        return head;
    }
}