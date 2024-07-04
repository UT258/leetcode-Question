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
    public ListNode mergeNodes(ListNode head) {
        
        //using two pointers 
        ListNode i=head;
        ListNode j=head.next;
        //dont need to change anything since first node  should always be zero 
        while(j!=null)//at the end of ll
        {    int sum=0;
            while(j!=null && j.val!=0)
            {
                //calculate the sum between two consecutive zeroes
              sum+=j.val;
              j=j.next;
            }
            i=i.next;
            i.val=sum;
             //now we have to skip the  0th node 
             if(j!=null)
             {
                j=j.next;

             }
             i.next=j;
        }
        return head.next;
    }

}