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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode follower = head;
        ListNode prev = head;
        ListNode runner = head;
        
        for(int i = 1; i<=k ; i++){
            
            prev = runner ;
            runner = runner.next;
        }
        
        while(runner!=null){
            runner = runner.next;
            follower = follower.next;
        }
        
        int temp = follower.val;
        follower.val= prev.val;
        prev.val = temp;
        
        return head;
        
    }
}