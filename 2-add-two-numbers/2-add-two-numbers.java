class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        int sum=0;
        ListNode dummynode=new ListNode(-1);
        ListNode head=dummynode;
        while(l1!=null&&l2!=null)
        {
            sum=l1.val+l2.val+c;
             ListNode d=new ListNode(sum%10);
           head.next=d;
            c=sum/10;
            l1=l1.next;
            l2=l2.next;
            head=head.next;
        }
        while(l1!=null)
        {
           sum=l1.val+c;
           ListNode d=new ListNode(sum%10);
           head.next=d;
            c=sum/10;
            l1=l1.next;
            head=head.next; 
        }
        while(l2!=null)
        {
           sum=l2.val+c;
           ListNode d=new ListNode(sum%10);
           head.next=d;
            c=sum/10;
            l2=l2.next;
            head=head.next; 
            
        }
        if(c!=0)
        {
            ListNode d=new ListNode(c);
           head.next=d;
        } 
       return dummynode.next; 
    }
}