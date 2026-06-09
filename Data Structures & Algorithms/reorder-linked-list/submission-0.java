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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode temp=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        slow.next=null;

        second=reverse(second);

        ListNode first=head;
        ListNode temp1=null;
        ListNode temp2=null;
        while(first!=null && second!=null)
        {
            temp1=first.next;
            temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }

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
