/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node.next == null)
        {
            node = null;
            return;
        }
        
        node.val = node.next.val;
        ListNode temp = node.next;
        
        node.next = node.next.next;
        temp.next = null;
        return;
    }
}