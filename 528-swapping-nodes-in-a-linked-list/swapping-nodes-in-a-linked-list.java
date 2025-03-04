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
    public int size(ListNode head){
        ListNode node=head;
        int c=0;
        while(node!=null)

        {
            c++;
            node=node.next;
        } 
        return c;
    }
    public ListNode getNode(ListNode head,int k)
    {
   ListNode node=head;
       while(k>0)
       {
        node=node.next;
        k--;
       }
       return node;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int n=size(head);
        if(head==null || head.next==null)
        {
            return head;//if the length is 1 or less return the head itself

        }
        ListNode first=getNode(head,k-1);
        ListNode last=getNode(head,n-k);
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
        return head;
    }
}