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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        temp=reverse(temp);
        ListNode head1=temp;
        int count=1;
        ListNode prev=null;
        while(temp!=null)
        {
            if(count==n)
            {
                if(count==1)
                    head1=temp.next;
                else
                    prev.next=temp.next;
                break;
            }
            prev=temp;
            temp=temp.next;
            count++;
        }
       return reverse(head1);
    }
    public static ListNode reverse(ListNode list1)
    {
        ListNode prev=null;
        ListNode curr=null;
        ListNode temp=list1;
        while(temp!=null)
        {
            curr=temp.next;
            temp.next=prev;
            prev=temp;
            temp=curr;
        }
        return prev;
    }
}