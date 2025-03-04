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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy =new ListNode();
        if(head==null ||head.next==null)//
        {
            return head;
        }
       ListNode prev=dummy;//point to dummy node
       ListNode current=head;
       while(current!=null && current.next!=null)
       {
         prev.next=current.next;
         current.next=prev.next.next;
         prev.next.next=current;//add the last connections
         prev=current;
         current=current.next;
       }
       return dummy.next;
        
    }
}