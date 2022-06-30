// { Driver Code Starts
import java.util.Scanner;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}
class GFG1 {
    public static void printList(Node head)
    {
        Node start=head;
        System.out.print(head.data+" ");
        head=head.next;
        while(head!=start)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        Node start=null,cur=null;
	        for(int i=0;i<n;i++)
	        {
	            int a=sc.nextInt();
	            Node ptr=new Node(a);
	            if(start==null)
	            {
	                start=ptr;
	                cur=ptr;
	            }
	            else
	            {
	                cur.next=ptr;
	                cur=ptr;
	            }
	        }
	        int delNode=sc.nextInt();
	        cur.next=start;
	        GFG obj=new GFG();
	        Node head=obj.deleteNode(start,delNode);
	        start=obj.reverse(head);
	        printList(start);
	    }
	}
}// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class GFG
{
    //This method returns the head of the LL after deleting node with value d.
    public static Node deleteNode(Node head,int d)
    {
        //Add your code here.
        if(head==null)
        return head;
        Node p = head;
        if(head.data == d){
            if(head == head.next){
                head = null;
                return head;
            }
            head = head.next;
        }
        while(p.next.data != d){
            p = p.next;
        }
        Node temp = p.next;
        p.next = p.next.next;
        temp.next = null;
        return head;
    }
    //This method returns the head node of the reversed Linked list.
    public static Node reverse(Node head)
    {
        //Add your code here
        if(head == head.next)
        return head;
        
        Node p = head;
        Node q = head.next;
        
        if(q.next == head){
            head = q;
            return head;
        }
        
        Node r = q.next;
        
        while(r != head){
            q.next = p;
            p = q;
            q = r;
            r =r.next;
        }
        
        if(r == head)
        {
            q.next = p;
            head = q;
            r.next = q;
        }
        
        return head;
    }
}